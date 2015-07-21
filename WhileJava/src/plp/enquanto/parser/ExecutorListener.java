package plp.enquanto.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import plp.enquanto.linguagem.Linguagem.Atribuicao;
import plp.enquanto.linguagem.Linguagem.Bloco;
import plp.enquanto.linguagem.Linguagem.Bool;
import plp.enquanto.linguagem.Linguagem.Booleano;
import plp.enquanto.linguagem.Linguagem.Comando;
import plp.enquanto.linguagem.Linguagem.ELogico;
import plp.enquanto.linguagem.Linguagem.Enquanto;
import plp.enquanto.linguagem.Linguagem.Escreva;
import plp.enquanto.linguagem.Linguagem.Exiba;
import plp.enquanto.linguagem.Linguagem.ExpBin;
import plp.enquanto.linguagem.Linguagem.ExpDiferente;
import plp.enquanto.linguagem.Linguagem.ExpDiv;
import plp.enquanto.linguagem.Linguagem.ExpIgual;
import plp.enquanto.linguagem.Linguagem.ExpMaiorIgual;
import plp.enquanto.linguagem.Linguagem.ExpMenorIgual;
import plp.enquanto.linguagem.Linguagem.ExpMult;
import plp.enquanto.linguagem.Linguagem.ExpPot;
import plp.enquanto.linguagem.Linguagem.ExpRel;
import plp.enquanto.linguagem.Linguagem.ExpSoma;
import plp.enquanto.linguagem.Linguagem.ExpSub;
import plp.enquanto.linguagem.Linguagem.Expressao;
import plp.enquanto.linguagem.Linguagem.Id;
import plp.enquanto.linguagem.Linguagem.Inteiro;
import plp.enquanto.linguagem.Linguagem.Leia;
import plp.enquanto.linguagem.Linguagem.NaoLogico;
import plp.enquanto.linguagem.Linguagem.OuLogico;
import plp.enquanto.linguagem.Linguagem.Para;
import plp.enquanto.linguagem.Linguagem.Programa;
import plp.enquanto.linguagem.Linguagem.Se;
import plp.enquanto.linguagem.Linguagem.Skip;
import plp.enquanto.linguagem.Linguagem.XouLogico;

public class ExecutorListener extends WhileBaseListener {
	private Leia leia = new Leia();
	private Skip skip = new Skip();
	private ParseTreeProperty<Object> values = new ParseTreeProperty<>();

	private Programa programa;

	public Programa getPrograma() {
		return programa;
	}

	private void setValue(ParseTree node, Object value) {
		values.put(node, value);
	}

	private Object getValue(ParseTree node) {
		return values.get(node);
	}

	@Override
	public void exitBooleano(@NotNull WhileParser.BooleanoContext ctx) {
		setValue(ctx, new Booleano(ctx.getText().equals("verdadeiro")));
	}

	@Override
	public void exitLeia(@NotNull WhileParser.LeiaContext ctx) {
		setValue(ctx, leia);
	}

	@Override
	public void exitSe(@NotNull WhileParser.SeContext ctx) {
		Bool se = null;
		Comando entao = null;
		Comando senao = null;
		
		List <Bool> senaoSe = new ArrayList();
		List <Comando> senaoEntao = new ArrayList();
		
		Iterator <ParseTree> itTokens = ctx.children.iterator();
		String tokenAnterior = "";
		
		while (itTokens.hasNext()) {
			String token = itTokens.next().getText();
			if (token.equals("se")) {
				se = (Bool) getValue(itTokens.next());
			} else if (token.equals("entao")) {
				if (tokenAnterior.equals("senaose")) {
					senaoEntao.add((Comando) getValue(itTokens.next()));
				} else {
					entao = (Comando) getValue(itTokens.next());					
				}
			} else if (token.equals("senaose")) {
				senaoSe.add((Bool) getValue(itTokens.next()));
			} else if (token.equals("senao")) {
				senao = (Comando) getValue(itTokens.next());
			}
			tokenAnterior = token;
		}
		
		
		
		setValue(ctx, new Se(se, entao, senaoSe, senaoEntao, senao));
	}

	@Override
	public void exitInteiro(@NotNull WhileParser.InteiroContext ctx) {
		setValue(ctx, new Inteiro(Integer.parseInt(ctx.getText())));
	}

	@Override
	public void exitSkip(@NotNull WhileParser.SkipContext ctx) {
		setValue(ctx, skip);
	}

	@Override
	public void exitEscreva(@NotNull WhileParser.EscrevaContext ctx) {
		Expressao exp = (Expressao) getValue(ctx.expressao());
		setValue(ctx, new Escreva(exp));
	}

	@Override
	public void exitPrograma(@NotNull WhileParser.ProgramaContext ctx) {
		@SuppressWarnings("unchecked")
		List<Comando> cmds = (List<Comando>) getValue(ctx.seqComando());
		programa = new Programa(cmds);
		setValue(ctx, programa);
	}

	@Override
	public void exitId(@NotNull WhileParser.IdContext ctx) {
		setValue(ctx, new Id(ctx.ID().getText()));
	}

	@Override
	public void exitSeqComando(@NotNull WhileParser.SeqComandoContext ctx) {
		List<Comando> comandos = new ArrayList<>();
		for (WhileParser.ComandoContext c : ctx.comando()) {
			comandos.add((Comando) getValue(c));
		}
		setValue(ctx, comandos);
	}

	@Override
	public void exitAtribuicao(@NotNull WhileParser.AtribuicaoContext ctx) {
		String id = ctx.ID().getText();
		Expressao exp = (Expressao) getValue(ctx.expressao());
		setValue(ctx, new Atribuicao(id, exp));
	}

	@Override
	public void exitBloco(@NotNull WhileParser.BlocoContext ctx) {
		@SuppressWarnings("unchecked")
		List<Comando> cmds = (List<Comando>) getValue(ctx.seqComando());
		setValue(ctx, new Bloco(cmds));
	}

	@Override
	public void exitOpBin(@NotNull WhileParser.OpBinContext ctx) {
		Expressao esq = (Expressao) getValue(ctx.expressao(0));
		Expressao dir = (Expressao) getValue(ctx.expressao(1));
		String op = ctx.getChild(1).getText();
		final ExpBin exp;
		switch (op) {
		case "+":
			exp = new ExpSoma(esq, dir);
			break;
		case "*":
			exp = new ExpMult(esq, dir);
			break;
		case "-":
			exp = new ExpSub(esq, dir);
			break;
		case "/":
			exp = new ExpDiv(esq, dir);
			break;
		case "^":
			exp = new ExpPot(esq, dir);
			break;
		default:
			exp = new ExpSoma(esq, dir);
		}
		setValue(ctx, exp);
	}

	@Override
	public void exitEnquanto(@NotNull WhileParser.EnquantoContext ctx) {
		Bool condicao = (Bool) getValue(ctx.bool());
		Comando comando = (Comando) getValue(ctx.comando());
		setValue(ctx, new Enquanto(condicao, comando));
	}
	
	@Override
	public void exitPara(@NotNull WhileParser.ParaContext ctx) {
		String id = ctx.ID().getText();
		Expressao de = (Expressao) getValue(ctx.expressao(0));
		Expressao ate = (Expressao) getValue(ctx.expressao(1));
		Comando faca = (Comando) getValue(ctx.comando());
		setValue(ctx, new Para(id, de, ate, faca));
	}

	@Override
	public void exitELogico(@NotNull WhileParser.ELogicoContext ctx) {
		Bool esq = (Bool) getValue(ctx.bool(0));
		Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new ELogico(esq, dir));
	}
	
	@Override
	public void exitOuLogico(@NotNull WhileParser.OuLogicoContext ctx) {
		Bool esq = (Bool) getValue(ctx.bool(0));
		Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new OuLogico(esq, dir));
	}
	
	@Override
	public void exitXouLogico(@NotNull WhileParser.XouLogicoContext ctx) {
		Bool esq = (Bool) getValue(ctx.bool(0));
		Bool dir = (Bool) getValue(ctx.bool(1));
		setValue(ctx, new XouLogico(esq, dir));
	}
	

	@Override
	public void exitBoolPar(@NotNull WhileParser.BoolParContext ctx) {
		setValue(ctx, getValue(ctx.bool()));
	}

	@Override
	public void exitNaoLogico(@NotNull WhileParser.NaoLogicoContext ctx) {
		Bool b = (Bool) getValue(ctx.bool());
		setValue(ctx, new NaoLogico(b));
	}

	@Override
	public void exitExpPar(@NotNull WhileParser.ExpParContext ctx) {
		setValue(ctx, getValue(ctx.expressao()));
	}

	@Override
	public void exitExiba(@NotNull WhileParser.ExibaContext ctx) {
		String t = ctx.Texto().getText();
		String texto = t.substring(1, t.length() - 1);
		setValue(ctx, new Exiba(texto));
	}

	@Override
	public void exitOpRel(@NotNull WhileParser.OpRelContext ctx) {
		Expressao esq = (Expressao) getValue(ctx.expressao(0));
		Expressao dir = (Expressao) getValue(ctx.expressao(1));
		String op = ctx.getChild(1).getText();
		final ExpRel exp;
		switch (op) {
		case "=":
			exp = new ExpIgual(esq, dir);
			break;
		case "<=":
			exp = new ExpMenorIgual(esq, dir);
			break;
		case ">=":
			exp = new ExpMaiorIgual(esq, dir);
			break;
		case "<>":
			exp = new ExpDiferente(esq, dir);
			break;
		default:
			exp = new ExpIgual(esq, dir);
		}
		setValue(ctx, exp);
	}
}
