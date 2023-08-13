// Generated from Expr.g4 by ANTLR 4.7.1
package acide.process.parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(ExprParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(ExprParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(ExprParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(ExprParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(ExprParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(ExprParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(ExprParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(ExprParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(ExprParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(ExprParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceModifier(ExprParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceModifier(ExprParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(ExprParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(ExprParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ExprParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ExprParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(ExprParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(ExprParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(ExprParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(ExprParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(ExprParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(ExprParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(ExprParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(ExprParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(ExprParser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(ExprParser.EnumConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(ExprParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(ExprParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(ExprParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(ExprParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(ExprParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(ExprParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(ExprParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(ExprParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(ExprParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(ExprParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(ExprParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(ExprParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(ExprParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(ExprParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(ExprParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(ExprParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(ExprParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(ExprParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeTypeOrVoid}.
	 * @param ctx the parse tree
	 */
	void enterTypeTypeOrVoid(ExprParser.TypeTypeOrVoidContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeTypeOrVoid}.
	 * @param ctx the parse tree
	 */
	void exitTypeTypeOrVoid(ExprParser.TypeTypeOrVoidContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericMethodDeclaration(ExprParser.GenericMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericMethodDeclaration(ExprParser.GenericMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorDeclaration(ExprParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorDeclaration(ExprParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(ExprParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(ExprParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCompactConstructorDeclaration(ExprParser.CompactConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#compactConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCompactConstructorDeclaration(ExprParser.CompactConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(ExprParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(ExprParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(ExprParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(ExprParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(ExprParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(ExprParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(ExprParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(ExprParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(ExprParser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(ExprParser.ConstantDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(ExprParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(ExprParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(ExprParser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(ExprParser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericInterfaceMethodDeclaration(ExprParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericInterfaceMethodDeclaration(ExprParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#interfaceCommonBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceCommonBodyDeclaration(ExprParser.InterfaceCommonBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#interfaceCommonBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceCommonBodyDeclaration(ExprParser.InterfaceCommonBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(ExprParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(ExprParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(ExprParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(ExprParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(ExprParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(ExprParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(ExprParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(ExprParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(ExprParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(ExprParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(ExprParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(ExprParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(ExprParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(ExprParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(ExprParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(ExprParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(ExprParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(ExprParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(ExprParser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(ExprParser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(ExprParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(ExprParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(ExprParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(ExprParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(ExprParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(ExprParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#lambdaLVTIList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaLVTIList(ExprParser.LambdaLVTIListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#lambdaLVTIList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaLVTIList(ExprParser.LambdaLVTIListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#lambdaLVTIParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaLVTIParameter(ExprParser.LambdaLVTIParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#lambdaLVTIParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaLVTIParameter(ExprParser.LambdaLVTIParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(ExprParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(ExprParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ExprParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ExprParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(ExprParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(ExprParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(ExprParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(ExprParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#altAnnotationQualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterAltAnnotationQualifiedName(ExprParser.AltAnnotationQualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#altAnnotationQualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitAltAnnotationQualifiedName(ExprParser.AltAnnotationQualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(ExprParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(ExprParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(ExprParser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(ExprParser.ElementValuePairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(ExprParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(ExprParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(ExprParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(ExprParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(ExprParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(ExprParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(ExprParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(ExprParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(ExprParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(ExprParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(ExprParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(ExprParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(ExprParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(ExprParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(ExprParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(ExprParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(ExprParser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(ExprParser.AnnotationMethodRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(ExprParser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(ExprParser.AnnotationConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(ExprParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(ExprParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterModuleDeclaration(ExprParser.ModuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#moduleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitModuleDeclaration(ExprParser.ModuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#moduleBody}.
	 * @param ctx the parse tree
	 */
	void enterModuleBody(ExprParser.ModuleBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#moduleBody}.
	 * @param ctx the parse tree
	 */
	void exitModuleBody(ExprParser.ModuleBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void enterModuleDirective(ExprParser.ModuleDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#moduleDirective}.
	 * @param ctx the parse tree
	 */
	void exitModuleDirective(ExprParser.ModuleDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void enterRequiresModifier(ExprParser.RequiresModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#requiresModifier}.
	 * @param ctx the parse tree
	 */
	void exitRequiresModifier(ExprParser.RequiresModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterRecordDeclaration(ExprParser.RecordDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#recordDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitRecordDeclaration(ExprParser.RecordDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void enterRecordHeader(ExprParser.RecordHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#recordHeader}.
	 * @param ctx the parse tree
	 */
	void exitRecordHeader(ExprParser.RecordHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponentList(ExprParser.RecordComponentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#recordComponentList}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponentList(ExprParser.RecordComponentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void enterRecordComponent(ExprParser.RecordComponentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#recordComponent}.
	 * @param ctx the parse tree
	 */
	void exitRecordComponent(ExprParser.RecordComponentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#recordBody}.
	 * @param ctx the parse tree
	 */
	void enterRecordBody(ExprParser.RecordBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#recordBody}.
	 * @param ctx the parse tree
	 */
	void exitRecordBody(ExprParser.RecordBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ExprParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ExprParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(ExprParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(ExprParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(ExprParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(ExprParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ExprParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ExprParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(ExprParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(ExprParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#localTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalTypeDeclaration(ExprParser.LocalTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#localTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalTypeDeclaration(ExprParser.LocalTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ExprParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ExprParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(ExprParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(ExprParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(ExprParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(ExprParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(ExprParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(ExprParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(ExprParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(ExprParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(ExprParser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(ExprParser.ResourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(ExprParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(ExprParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(ExprParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(ExprParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(ExprParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(ExprParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(ExprParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(ExprParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(ExprParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(ExprParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(ExprParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(ExprParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(ExprParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(ExprParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(ExprParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(ExprParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(ExprParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(ExprParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExprParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#pattern}.
	 * @param ctx the parse tree
	 */
	void enterPattern(ExprParser.PatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#pattern}.
	 * @param ctx the parse tree
	 */
	void exitPattern(ExprParser.PatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(ExprParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(ExprParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(ExprParser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(ExprParser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(ExprParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(ExprParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ExprParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ExprParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void enterSwitchExpression(ExprParser.SwitchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#switchExpression}.
	 * @param ctx the parse tree
	 */
	void exitSwitchExpression(ExprParser.SwitchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#switchLabeledRule}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabeledRule(ExprParser.SwitchLabeledRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#switchLabeledRule}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabeledRule(ExprParser.SwitchLabeledRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#guardedPattern}.
	 * @param ctx the parse tree
	 */
	void enterGuardedPattern(ExprParser.GuardedPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#guardedPattern}.
	 * @param ctx the parse tree
	 */
	void exitGuardedPattern(ExprParser.GuardedPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#switchRuleOutcome}.
	 * @param ctx the parse tree
	 */
	void enterSwitchRuleOutcome(ExprParser.SwitchRuleOutcomeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#switchRuleOutcome}.
	 * @param ctx the parse tree
	 */
	void exitSwitchRuleOutcome(ExprParser.SwitchRuleOutcomeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(ExprParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(ExprParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(ExprParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(ExprParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(ExprParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(ExprParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(ExprParser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(ExprParser.InnerCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(ExprParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(ExprParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(ExprParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(ExprParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(ExprParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(ExprParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(ExprParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(ExprParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArgumentsOrDiamond(ExprParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArgumentsOrDiamond(ExprParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(ExprParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(ExprParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(ExprParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(ExprParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeType}.
	 * @param ctx the parse tree
	 */
	void enterTypeType(ExprParser.TypeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeType}.
	 * @param ctx the parse tree
	 */
	void exitTypeType(ExprParser.TypeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(ExprParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(ExprParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(ExprParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(ExprParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(ExprParser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(ExprParser.SuperSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(ExprParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(ExprParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(ExprParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(ExprParser.ArgumentsContext ctx);
}
