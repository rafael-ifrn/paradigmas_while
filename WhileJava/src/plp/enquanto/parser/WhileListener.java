package plp.enquanto.parser;
// Generated from While.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileParser}.
 */
public interface WhileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(WhileParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(WhileParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileParser#seqComando}.
	 * @param ctx the parse tree
	 */
	void enterSeqComando(WhileParser.SeqComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileParser#seqComando}.
	 * @param ctx the parse tree
	 */
	void exitSeqComando(WhileParser.SeqComandoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atribuicao}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(WhileParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atribuicao}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(WhileParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code skip}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterSkip(WhileParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code skip}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitSkip(WhileParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code se}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterSe(WhileParser.SeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code se}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitSe(WhileParser.SeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code enquanto}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterEnquanto(WhileParser.EnquantoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code enquanto}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitEnquanto(WhileParser.EnquantoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code para}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterPara(WhileParser.ParaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code para}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitPara(WhileParser.ParaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exiba}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterExiba(WhileParser.ExibaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exiba}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitExiba(WhileParser.ExibaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code escreva}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterEscreva(WhileParser.EscrevaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code escreva}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitEscreva(WhileParser.EscrevaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bloco}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterBloco(WhileParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bloco}
	 * labeled alternative in {@link WhileParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitBloco(WhileParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leia}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterLeia(WhileParser.LeiaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leia}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitLeia(WhileParser.LeiaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inteiro}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterInteiro(WhileParser.InteiroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inteiro}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitInteiro(WhileParser.InteiroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opBin}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterOpBin(WhileParser.OpBinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opBin}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitOpBin(WhileParser.OpBinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterId(WhileParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitId(WhileParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expPar}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpPar(WhileParser.ExpParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expPar}
	 * labeled alternative in {@link WhileParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpPar(WhileParser.ExpParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code xouLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterXouLogico(WhileParser.XouLogicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code xouLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitXouLogico(WhileParser.XouLogicoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterELogico(WhileParser.ELogicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitELogico(WhileParser.ELogicoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleano}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBooleano(WhileParser.BooleanoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleano}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBooleano(WhileParser.BooleanoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code naoLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterNaoLogico(WhileParser.NaoLogicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code naoLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitNaoLogico(WhileParser.NaoLogicoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opRel}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterOpRel(WhileParser.OpRelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opRel}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitOpRel(WhileParser.OpRelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolPar}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBoolPar(WhileParser.BoolParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolPar}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBoolPar(WhileParser.BoolParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ouLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterOuLogico(WhileParser.OuLogicoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ouLogico}
	 * labeled alternative in {@link WhileParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitOuLogico(WhileParser.OuLogicoContext ctx);
}