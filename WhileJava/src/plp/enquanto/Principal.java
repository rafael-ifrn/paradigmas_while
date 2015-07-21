package plp.enquanto;

import static java.util.Arrays.asList;
import static plp.enquanto.linguagem.Linguagem.leia;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import plp.enquanto.linguagem.Linguagem.Atribuicao;
import plp.enquanto.linguagem.Linguagem.ELogico;
import plp.enquanto.linguagem.Linguagem.Exiba;
import plp.enquanto.linguagem.Linguagem.ExpMaiorIgual;
import plp.enquanto.linguagem.Linguagem.ExpMenorIgual;
import plp.enquanto.linguagem.Linguagem.ExpSoma;
import plp.enquanto.linguagem.Linguagem.Id;
import plp.enquanto.linguagem.Linguagem.Inteiro;
import plp.enquanto.linguagem.Linguagem.Programa;
import plp.enquanto.linguagem.Linguagem.Se;
import plp.enquanto.parser.ExecutorListener;
import plp.enquanto.parser.WhileLexer;
import plp.enquanto.parser.WhileParser;

public class Principal {

	private static ParseTree parse(String programa) {
		final ANTLRInputStream input = new ANTLRInputStream(programa);
		final WhileLexer lexer = new WhileLexer(input);
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final WhileParser parser = new WhileParser(tokens);
		return parser.programa();
	}

	public static void main(String... args) throws IOException {
		String programa = "x:=10; y:=leia ; c:= x + y; "
				+ "se c >= 30 e c <= 30 entao exiba \"igual\" "
				+ "senaose c >= 30 entao exiba \"maior\" "
				+ "senao exiba \"menor\"";
		final ParseTree tree = parse(programa);
		final ParseTreeWalker walker = new ParseTreeWalker();
		final ExecutorListener listener = new ExecutorListener();
		walker.walk(listener, tree);
		Programa p1 = listener.getPrograma();
		// O parser devolve um objeto 'Programa' semelhante ao programa a seguir:
		Programa p2 = new Programa(asList(
				new Atribuicao("x", new Inteiro(10)),                       // x := 10
				new Atribuicao("y", leia),                                  // y := leia
				new Atribuicao("c", new ExpSoma(new Id("x"), new Id("y"))), // c := x + y
				new Se(
						new ELogico( 												//se
								new ExpMenorIgual(new Id("c"), new Inteiro(30)),	// c <= 30 e
								new ExpMaiorIgual(new Id("c"), new Inteiro(30))),	// c >= 30 entao
						new Exiba("igual"),											//entao exiba "igual"
						asList(
							new ExpMaiorIgual(new Id("c"), new Inteiro(30))			//senaose c >= 30
						),
						asList(
							new Exiba("maior")										//entao exiba "maior"
						),
						new Exiba("menor"))                                 // senao exiba "menor"
				));
		p1.execute();
		p2.execute();
	}
}
