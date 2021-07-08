/*
 * generated by Xtext 2.25.0
 */
package su.nsk.iae.post.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import su.nsk.iae.post.ide.contentassist.antlr.internal.InternalPoSTParser;
import su.nsk.iae.post.services.PoSTGrammarAccess;

public class PoSTParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(PoSTGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, PoSTGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getModelAccess().getAlternatives(), "rule__Model__Alternatives");
			builder.put(grammarAccess.getSingleResourceAccess().getAlternatives_1(), "rule__SingleResource__Alternatives_1");
			builder.put(grammarAccess.getTaskInitializationAccess().getAlternatives(), "rule__TaskInitialization__Alternatives");
			builder.put(grammarAccess.getProgramConfElementAccess().getAlternatives(), "rule__ProgramConfElement__Alternatives");
			builder.put(grammarAccess.getAttachVariableConfElementAccess().getAlternatives_2(), "rule__AttachVariableConfElement__Alternatives_2");
			builder.put(grammarAccess.getProgramAccess().getAlternatives_2(), "rule__Program__Alternatives_2");
			builder.put(grammarAccess.getFunctionBlockAccess().getAlternatives_2(), "rule__FunctionBlock__Alternatives_2");
			builder.put(grammarAccess.getProcessAccess().getAlternatives_2(), "rule__Process__Alternatives_2");
			builder.put(grammarAccess.getSetStateStatementAccess().getAlternatives_2(), "rule__SetStateStatement__Alternatives_2");
			builder.put(grammarAccess.getProcessStatementsAccess().getAlternatives(), "rule__ProcessStatements__Alternatives");
			builder.put(grammarAccess.getProcessStatusExpressionAccess().getAlternatives_4(), "rule__ProcessStatusExpression__Alternatives_4");
			builder.put(grammarAccess.getStartProcessStatementAccess().getAlternatives(), "rule__StartProcessStatement__Alternatives");
			builder.put(grammarAccess.getTimeoutStatementAccess().getAlternatives_1(), "rule__TimeoutStatement__Alternatives_1");
			builder.put(grammarAccess.getUnaryExpressionAccess().getAlternatives(), "rule__UnaryExpression__Alternatives");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getAssignmentStatementAccess().getAlternatives_0(), "rule__AssignmentStatement__Alternatives_0");
			builder.put(grammarAccess.getSelectionStatementAccess().getAlternatives(), "rule__SelectionStatement__Alternatives");
			builder.put(grammarAccess.getIterationStatementAccess().getAlternatives(), "rule__IterationStatement__Alternatives");
			builder.put(grammarAccess.getVarInitDeclarationAccess().getAlternatives_2(), "rule__VarInitDeclaration__Alternatives_2");
			builder.put(grammarAccess.getGlobalVarDeclarationAccess().getAlternatives_2(), "rule__GlobalVarDeclaration__Alternatives_2");
			builder.put(grammarAccess.getDataTypeNameAccess().getAlternatives(), "rule__DataTypeName__Alternatives");
			builder.put(grammarAccess.getNumericTypeNameAccess().getAlternatives(), "rule__NumericTypeName__Alternatives");
			builder.put(grammarAccess.getIntegerTypeNameAccess().getAlternatives(), "rule__IntegerTypeName__Alternatives");
			builder.put(grammarAccess.getConstantAccess().getAlternatives(), "rule__Constant__Alternatives");
			builder.put(grammarAccess.getNumericLiteralAccess().getAlternatives(), "rule__NumericLiteral__Alternatives");
			builder.put(grammarAccess.getAssignmentTypeAccess().getAlternatives(), "rule__AssignmentType__Alternatives");
			builder.put(grammarAccess.getCompOperatorAccess().getAlternatives(), "rule__CompOperator__Alternatives");
			builder.put(grammarAccess.getEquOperatorAccess().getAlternatives(), "rule__EquOperator__Alternatives");
			builder.put(grammarAccess.getAddOperatorAccess().getAlternatives(), "rule__AddOperator__Alternatives");
			builder.put(grammarAccess.getMulOperatorAccess().getAlternatives(), "rule__MulOperator__Alternatives");
			builder.put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
			builder.put(grammarAccess.getConfigurationAccess().getGroup(), "rule__Configuration__Group__0");
			builder.put(grammarAccess.getConfigurationAccess().getGroup_2(), "rule__Configuration__Group_2__0");
			builder.put(grammarAccess.getResourceAccess().getGroup(), "rule__Resource__Group__0");
			builder.put(grammarAccess.getSingleResourceAccess().getGroup(), "rule__SingleResource__Group__0");
			builder.put(grammarAccess.getSingleResourceAccess().getGroup_1_0(), "rule__SingleResource__Group_1_0__0");
			builder.put(grammarAccess.getSingleResourceAccess().getGroup_1_1(), "rule__SingleResource__Group_1_1__0");
			builder.put(grammarAccess.getTaskAccess().getGroup(), "rule__Task__Group__0");
			builder.put(grammarAccess.getTaskInitializationAccess().getGroup_0(), "rule__TaskInitialization__Group_0__0");
			builder.put(grammarAccess.getTaskInitializationAccess().getGroup_1(), "rule__TaskInitialization__Group_1__0");
			builder.put(grammarAccess.getTaskInitializationAccess().getGroup_1_0(), "rule__TaskInitialization__Group_1_0__0");
			builder.put(grammarAccess.getProgramConfigurationAccess().getGroup(), "rule__ProgramConfiguration__Group__0");
			builder.put(grammarAccess.getProgramConfigurationAccess().getGroup_2(), "rule__ProgramConfiguration__Group_2__0");
			builder.put(grammarAccess.getProgramConfigurationAccess().getGroup_5(), "rule__ProgramConfiguration__Group_5__0");
			builder.put(grammarAccess.getProgramConfElementsAccess().getGroup(), "rule__ProgramConfElements__Group__0");
			builder.put(grammarAccess.getProgramConfElementsAccess().getGroup_1(), "rule__ProgramConfElements__Group_1__0");
			builder.put(grammarAccess.getAttachVariableConfElementAccess().getGroup(), "rule__AttachVariableConfElement__Group__0");
			builder.put(grammarAccess.getTemplateProcessConfElementAccess().getGroup(), "rule__TemplateProcessConfElement__Group__0");
			builder.put(grammarAccess.getTemplateProcessConfElementAccess().getGroup_5(), "rule__TemplateProcessConfElement__Group_5__0");
			builder.put(grammarAccess.getProcessTemplateElementsAccess().getGroup(), "rule__ProcessTemplateElements__Group__0");
			builder.put(grammarAccess.getProcessTemplateElementsAccess().getGroup_1(), "rule__ProcessTemplateElements__Group_1__0");
			builder.put(grammarAccess.getProgramAccess().getGroup(), "rule__Program__Group__0");
			builder.put(grammarAccess.getFunctionBlockAccess().getGroup(), "rule__FunctionBlock__Group__0");
			builder.put(grammarAccess.getProcessAccess().getGroup(), "rule__Process__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getSetStateStatementAccess().getGroup(), "rule__SetStateStatement__Group__0");
			builder.put(grammarAccess.getSetStateStatementAccess().getGroup_2_0(), "rule__SetStateStatement__Group_2_0__0");
			builder.put(grammarAccess.getProcessStatusExpressionAccess().getGroup(), "rule__ProcessStatusExpression__Group__0");
			builder.put(grammarAccess.getStartProcessStatementAccess().getGroup_0(), "rule__StartProcessStatement__Group_0__0");
			builder.put(grammarAccess.getStartProcessStatementAccess().getGroup_0_1(), "rule__StartProcessStatement__Group_0_1__0");
			builder.put(grammarAccess.getStartProcessStatementAccess().getGroup_1(), "rule__StartProcessStatement__Group_1__0");
			builder.put(grammarAccess.getStopProcessStatementAccess().getGroup(), "rule__StopProcessStatement__Group__0");
			builder.put(grammarAccess.getStopProcessStatementAccess().getGroup_2(), "rule__StopProcessStatement__Group_2__0");
			builder.put(grammarAccess.getErrorProcessStatementAccess().getGroup(), "rule__ErrorProcessStatement__Group__0");
			builder.put(grammarAccess.getErrorProcessStatementAccess().getGroup_2(), "rule__ErrorProcessStatement__Group_2__0");
			builder.put(grammarAccess.getTimeoutStatementAccess().getGroup(), "rule__TimeoutStatement__Group__0");
			builder.put(grammarAccess.getResetTimerStatementAccess().getGroup(), "rule__ResetTimerStatement__Group__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1(), "rule__Expression__Group_1__0");
			builder.put(grammarAccess.getXorExpressionAccess().getGroup(), "rule__XorExpression__Group__0");
			builder.put(grammarAccess.getXorExpressionAccess().getGroup_1(), "rule__XorExpression__Group_1__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
			builder.put(grammarAccess.getAndExpressionAccess().getGroup_1(), "rule__AndExpression__Group_1__0");
			builder.put(grammarAccess.getCompExpressionAccess().getGroup(), "rule__CompExpression__Group__0");
			builder.put(grammarAccess.getCompExpressionAccess().getGroup_1(), "rule__CompExpression__Group_1__0");
			builder.put(grammarAccess.getEquExpressionAccess().getGroup(), "rule__EquExpression__Group__0");
			builder.put(grammarAccess.getEquExpressionAccess().getGroup_1(), "rule__EquExpression__Group_1__0");
			builder.put(grammarAccess.getAddExpressionAccess().getGroup(), "rule__AddExpression__Group__0");
			builder.put(grammarAccess.getAddExpressionAccess().getGroup_1(), "rule__AddExpression__Group_1__0");
			builder.put(grammarAccess.getMulExpressionAccess().getGroup(), "rule__MulExpression__Group__0");
			builder.put(grammarAccess.getMulExpressionAccess().getGroup_1(), "rule__MulExpression__Group_1__0");
			builder.put(grammarAccess.getPowerExpressionAccess().getGroup(), "rule__PowerExpression__Group__0");
			builder.put(grammarAccess.getPowerExpressionAccess().getGroup_1(), "rule__PowerExpression__Group_1__0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getGroup_1(), "rule__UnaryExpression__Group_1__0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getGroup_4(), "rule__PrimaryExpression__Group_4__0");
			builder.put(grammarAccess.getStatementListAccess().getGroup(), "rule__StatementList__Group__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_0(), "rule__Statement__Group_0__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_3(), "rule__Statement__Group_3__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_4(), "rule__Statement__Group_4__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_5(), "rule__Statement__Group_5__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_6(), "rule__Statement__Group_6__0");
			builder.put(grammarAccess.getStatementAccess().getGroup_7(), "rule__Statement__Group_7__0");
			builder.put(grammarAccess.getAssignmentStatementAccess().getGroup(), "rule__AssignmentStatement__Group__0");
			builder.put(grammarAccess.getIfStatementAccess().getGroup(), "rule__IfStatement__Group__0");
			builder.put(grammarAccess.getIfStatementAccess().getGroup_4(), "rule__IfStatement__Group_4__0");
			builder.put(grammarAccess.getIfStatementAccess().getGroup_5(), "rule__IfStatement__Group_5__0");
			builder.put(grammarAccess.getCaseStatementAccess().getGroup(), "rule__CaseStatement__Group__0");
			builder.put(grammarAccess.getCaseStatementAccess().getGroup_4(), "rule__CaseStatement__Group_4__0");
			builder.put(grammarAccess.getCaseElementAccess().getGroup(), "rule__CaseElement__Group__0");
			builder.put(grammarAccess.getCaseListAccess().getGroup(), "rule__CaseList__Group__0");
			builder.put(grammarAccess.getCaseListAccess().getGroup_1(), "rule__CaseList__Group_1__0");
			builder.put(grammarAccess.getForStatementAccess().getGroup(), "rule__ForStatement__Group__0");
			builder.put(grammarAccess.getForListAccess().getGroup(), "rule__ForList__Group__0");
			builder.put(grammarAccess.getForListAccess().getGroup_3(), "rule__ForList__Group_3__0");
			builder.put(grammarAccess.getWhileStatementAccess().getGroup(), "rule__WhileStatement__Group__0");
			builder.put(grammarAccess.getRepeatStatementAccess().getGroup(), "rule__RepeatStatement__Group__0");
			builder.put(grammarAccess.getSubprogramControlStatementAccess().getGroup(), "rule__SubprogramControlStatement__Group__0");
			builder.put(grammarAccess.getExitStatementAccess().getGroup(), "rule__ExitStatement__Group__0");
			builder.put(grammarAccess.getArrayVariableAccess().getGroup(), "rule__ArrayVariable__Group__0");
			builder.put(grammarAccess.getVarInitDeclarationAccess().getGroup(), "rule__VarInitDeclaration__Group__0");
			builder.put(grammarAccess.getVarListAccess().getGroup(), "rule__VarList__Group__0");
			builder.put(grammarAccess.getVarListAccess().getGroup_1(), "rule__VarList__Group_1__0");
			builder.put(grammarAccess.getInputVarDeclarationAccess().getGroup(), "rule__InputVarDeclaration__Group__0");
			builder.put(grammarAccess.getInputVarDeclarationAccess().getGroup_1(), "rule__InputVarDeclaration__Group_1__0");
			builder.put(grammarAccess.getOutputVarDeclarationAccess().getGroup(), "rule__OutputVarDeclaration__Group__0");
			builder.put(grammarAccess.getOutputVarDeclarationAccess().getGroup_1(), "rule__OutputVarDeclaration__Group_1__0");
			builder.put(grammarAccess.getInputOutputVarDeclarationAccess().getGroup(), "rule__InputOutputVarDeclaration__Group__0");
			builder.put(grammarAccess.getInputOutputVarDeclarationAccess().getGroup_1(), "rule__InputOutputVarDeclaration__Group_1__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup(), "rule__VarDeclaration__Group__0");
			builder.put(grammarAccess.getVarDeclarationAccess().getGroup_2(), "rule__VarDeclaration__Group_2__0");
			builder.put(grammarAccess.getTempVarDeclarationAccess().getGroup(), "rule__TempVarDeclaration__Group__0");
			builder.put(grammarAccess.getTempVarDeclarationAccess().getGroup_1(), "rule__TempVarDeclaration__Group_1__0");
			builder.put(grammarAccess.getExternalVarDeclarationAccess().getGroup(), "rule__ExternalVarDeclaration__Group__0");
			builder.put(grammarAccess.getExternalVarDeclarationAccess().getGroup_2(), "rule__ExternalVarDeclaration__Group_2__0");
			builder.put(grammarAccess.getExternalVarInitDeclarationAccess().getGroup(), "rule__ExternalVarInitDeclaration__Group__0");
			builder.put(grammarAccess.getGlobalVarDeclarationAccess().getGroup(), "rule__GlobalVarDeclaration__Group__0");
			builder.put(grammarAccess.getGlobalVarDeclarationAccess().getGroup_2_0(), "rule__GlobalVarDeclaration__Group_2_0__0");
			builder.put(grammarAccess.getGlobalVarDeclarationAccess().getGroup_2_1(), "rule__GlobalVarDeclaration__Group_2_1__0");
			builder.put(grammarAccess.getGlobalVarInitDeclarationAccess().getGroup(), "rule__GlobalVarInitDeclaration__Group__0");
			builder.put(grammarAccess.getArraySpecInitAccess().getGroup(), "rule__ArraySpecInit__Group__0");
			builder.put(grammarAccess.getArraySpecInitAccess().getGroup_1(), "rule__ArraySpecInit__Group_1__0");
			builder.put(grammarAccess.getArraySpecificationAccess().getGroup(), "rule__ArraySpecification__Group__0");
			builder.put(grammarAccess.getArrayInitializationAccess().getGroup(), "rule__ArrayInitialization__Group__0");
			builder.put(grammarAccess.getArrayInitializationAccess().getGroup_2(), "rule__ArrayInitialization__Group_2__0");
			builder.put(grammarAccess.getTimeLiteralAccess().getGroup(), "rule__TimeLiteral__Group__0");
			builder.put(grammarAccess.getSimpleSpecificationInitAccess().getGroup(), "rule__SimpleSpecificationInit__Group__0");
			builder.put(grammarAccess.getSimpleSpecificationInitAccess().getGroup_2(), "rule__SimpleSpecificationInit__Group_2__0");
			builder.put(grammarAccess.getConstantAccess().getGroup_2(), "rule__Constant__Group_2__0");
			builder.put(grammarAccess.getConstantAccess().getGroup_3(), "rule__Constant__Group_3__0");
			builder.put(grammarAccess.getConstantAccess().getGroup_4(), "rule__Constant__Group_4__0");
			builder.put(grammarAccess.getConstantAccess().getGroup_5(), "rule__Constant__Group_5__0");
			builder.put(grammarAccess.getSignedIntegerAccess().getGroup(), "rule__SignedInteger__Group__0");
			builder.put(grammarAccess.getIntegerLiteralAccess().getGroup(), "rule__IntegerLiteral__Group__0");
			builder.put(grammarAccess.getIntegerLiteralAccess().getGroup_0(), "rule__IntegerLiteral__Group_0__0");
			builder.put(grammarAccess.getRealLiteralAccess().getGroup(), "rule__RealLiteral__Group__0");
			builder.put(grammarAccess.getRealLiteralAccess().getGroup_0(), "rule__RealLiteral__Group_0__0");
			builder.put(grammarAccess.getModelAccess().getConfsAssignment_0(), "rule__Model__ConfsAssignment_0");
			builder.put(grammarAccess.getModelAccess().getGlobVarsAssignment_1(), "rule__Model__GlobVarsAssignment_1");
			builder.put(grammarAccess.getModelAccess().getProgramsAssignment_2(), "rule__Model__ProgramsAssignment_2");
			builder.put(grammarAccess.getModelAccess().getFbsAssignment_3(), "rule__Model__FbsAssignment_3");
			builder.put(grammarAccess.getConfigurationAccess().getNameAssignment_1(), "rule__Configuration__NameAssignment_1");
			builder.put(grammarAccess.getConfigurationAccess().getConfGlobVarsAssignment_2_0(), "rule__Configuration__ConfGlobVarsAssignment_2_0");
			builder.put(grammarAccess.getConfigurationAccess().getResourcesAssignment_2_1(), "rule__Configuration__ResourcesAssignment_2_1");
			builder.put(grammarAccess.getResourceAccess().getNameAssignment_1(), "rule__Resource__NameAssignment_1");
			builder.put(grammarAccess.getResourceAccess().getTypeAssignment_3(), "rule__Resource__TypeAssignment_3");
			builder.put(grammarAccess.getResourceAccess().getResGlobVarsAssignment_4(), "rule__Resource__ResGlobVarsAssignment_4");
			builder.put(grammarAccess.getResourceAccess().getResStatementAssignment_5(), "rule__Resource__ResStatementAssignment_5");
			builder.put(grammarAccess.getSingleResourceAccess().getTasksAssignment_1_0_0(), "rule__SingleResource__TasksAssignment_1_0_0");
			builder.put(grammarAccess.getSingleResourceAccess().getProgramConfsAssignment_1_1_0(), "rule__SingleResource__ProgramConfsAssignment_1_1_0");
			builder.put(grammarAccess.getTaskAccess().getNameAssignment_1(), "rule__Task__NameAssignment_1");
			builder.put(grammarAccess.getTaskAccess().getInitAssignment_3(), "rule__Task__InitAssignment_3");
			builder.put(grammarAccess.getTaskInitializationAccess().getSingleAssignment_0_2(), "rule__TaskInitialization__SingleAssignment_0_2");
			builder.put(grammarAccess.getTaskInitializationAccess().getIntervalAssignment_1_0_2(), "rule__TaskInitialization__IntervalAssignment_1_0_2");
			builder.put(grammarAccess.getTaskInitializationAccess().getPriorityAssignment_1_4(), "rule__TaskInitialization__PriorityAssignment_1_4");
			builder.put(grammarAccess.getProgramConfigurationAccess().getNameAssignment_1(), "rule__ProgramConfiguration__NameAssignment_1");
			builder.put(grammarAccess.getProgramConfigurationAccess().getTaskAssignment_2_1(), "rule__ProgramConfiguration__TaskAssignment_2_1");
			builder.put(grammarAccess.getProgramConfigurationAccess().getProgramAssignment_4(), "rule__ProgramConfiguration__ProgramAssignment_4");
			builder.put(grammarAccess.getProgramConfigurationAccess().getArgsAssignment_5_1(), "rule__ProgramConfiguration__ArgsAssignment_5_1");
			builder.put(grammarAccess.getProgramConfElementsAccess().getElementsAssignment_0(), "rule__ProgramConfElements__ElementsAssignment_0");
			builder.put(grammarAccess.getProgramConfElementsAccess().getElementsAssignment_1_1(), "rule__ProgramConfElements__ElementsAssignment_1_1");
			builder.put(grammarAccess.getAttachVariableConfElementAccess().getProgramVarAssignment_0(), "rule__AttachVariableConfElement__ProgramVarAssignment_0");
			builder.put(grammarAccess.getAttachVariableConfElementAccess().getAssigAssignment_1(), "rule__AttachVariableConfElement__AssigAssignment_1");
			builder.put(grammarAccess.getAttachVariableConfElementAccess().getAttVarAssignment_2_0(), "rule__AttachVariableConfElement__AttVarAssignment_2_0");
			builder.put(grammarAccess.getAttachVariableConfElementAccess().getConstAssignment_2_1(), "rule__AttachVariableConfElement__ConstAssignment_2_1");
			builder.put(grammarAccess.getTemplateProcessConfElementAccess().getActiveAssignment_1(), "rule__TemplateProcessConfElement__ActiveAssignment_1");
			builder.put(grammarAccess.getTemplateProcessConfElementAccess().getNameAssignment_2(), "rule__TemplateProcessConfElement__NameAssignment_2");
			builder.put(grammarAccess.getTemplateProcessConfElementAccess().getProcessAssignment_4(), "rule__TemplateProcessConfElement__ProcessAssignment_4");
			builder.put(grammarAccess.getTemplateProcessConfElementAccess().getArgsAssignment_5_1(), "rule__TemplateProcessConfElement__ArgsAssignment_5_1");
			builder.put(grammarAccess.getProcessTemplateElementsAccess().getElementsAssignment_0(), "rule__ProcessTemplateElements__ElementsAssignment_0");
			builder.put(grammarAccess.getProcessTemplateElementsAccess().getElementsAssignment_1_1(), "rule__ProcessTemplateElements__ElementsAssignment_1_1");
			builder.put(grammarAccess.getProgramAccess().getNameAssignment_1(), "rule__Program__NameAssignment_1");
			builder.put(grammarAccess.getProgramAccess().getProgInVarsAssignment_2_0(), "rule__Program__ProgInVarsAssignment_2_0");
			builder.put(grammarAccess.getProgramAccess().getProgOutVarsAssignment_2_1(), "rule__Program__ProgOutVarsAssignment_2_1");
			builder.put(grammarAccess.getProgramAccess().getProgInOutVarsAssignment_2_2(), "rule__Program__ProgInOutVarsAssignment_2_2");
			builder.put(grammarAccess.getProgramAccess().getProgVarsAssignment_2_3(), "rule__Program__ProgVarsAssignment_2_3");
			builder.put(grammarAccess.getProgramAccess().getProgTempVarsAssignment_2_4(), "rule__Program__ProgTempVarsAssignment_2_4");
			builder.put(grammarAccess.getProgramAccess().getProgExternVarsAssignment_2_5(), "rule__Program__ProgExternVarsAssignment_2_5");
			builder.put(grammarAccess.getProgramAccess().getProcessesAssignment_3(), "rule__Program__ProcessesAssignment_3");
			builder.put(grammarAccess.getFunctionBlockAccess().getNameAssignment_1(), "rule__FunctionBlock__NameAssignment_1");
			builder.put(grammarAccess.getFunctionBlockAccess().getFbInVarsAssignment_2_0(), "rule__FunctionBlock__FbInVarsAssignment_2_0");
			builder.put(grammarAccess.getFunctionBlockAccess().getFbOutVarsAssignment_2_1(), "rule__FunctionBlock__FbOutVarsAssignment_2_1");
			builder.put(grammarAccess.getFunctionBlockAccess().getFbInOutVarsAssignment_2_2(), "rule__FunctionBlock__FbInOutVarsAssignment_2_2");
			builder.put(grammarAccess.getFunctionBlockAccess().getFbVarsAssignment_2_3(), "rule__FunctionBlock__FbVarsAssignment_2_3");
			builder.put(grammarAccess.getFunctionBlockAccess().getFbTempVarsAssignment_2_4(), "rule__FunctionBlock__FbTempVarsAssignment_2_4");
			builder.put(grammarAccess.getFunctionBlockAccess().getFbExternVarsAssignment_2_5(), "rule__FunctionBlock__FbExternVarsAssignment_2_5");
			builder.put(grammarAccess.getFunctionBlockAccess().getProcessesAssignment_3(), "rule__FunctionBlock__ProcessesAssignment_3");
			builder.put(grammarAccess.getProcessAccess().getNameAssignment_1(), "rule__Process__NameAssignment_1");
			builder.put(grammarAccess.getProcessAccess().getProcInVarsAssignment_2_0(), "rule__Process__ProcInVarsAssignment_2_0");
			builder.put(grammarAccess.getProcessAccess().getProcOutVarsAssignment_2_1(), "rule__Process__ProcOutVarsAssignment_2_1");
			builder.put(grammarAccess.getProcessAccess().getProcInOutVarsAssignment_2_2(), "rule__Process__ProcInOutVarsAssignment_2_2");
			builder.put(grammarAccess.getProcessAccess().getProcVarsAssignment_2_3(), "rule__Process__ProcVarsAssignment_2_3");
			builder.put(grammarAccess.getProcessAccess().getProcTempVarsAssignment_2_4(), "rule__Process__ProcTempVarsAssignment_2_4");
			builder.put(grammarAccess.getProcessAccess().getStatesAssignment_3(), "rule__Process__StatesAssignment_3");
			builder.put(grammarAccess.getStateAccess().getNameAssignment_1(), "rule__State__NameAssignment_1");
			builder.put(grammarAccess.getStateAccess().getLoopedAssignment_2(), "rule__State__LoopedAssignment_2");
			builder.put(grammarAccess.getStateAccess().getStatementAssignment_3(), "rule__State__StatementAssignment_3");
			builder.put(grammarAccess.getStateAccess().getTimeoutAssignment_4(), "rule__State__TimeoutAssignment_4");
			builder.put(grammarAccess.getSetStateStatementAccess().getStateAssignment_2_0_1(), "rule__SetStateStatement__StateAssignment_2_0_1");
			builder.put(grammarAccess.getSetStateStatementAccess().getNextAssignment_2_1(), "rule__SetStateStatement__NextAssignment_2_1");
			builder.put(grammarAccess.getProcessStatusExpressionAccess().getProcessAssignment_1(), "rule__ProcessStatusExpression__ProcessAssignment_1");
			builder.put(grammarAccess.getProcessStatusExpressionAccess().getActiveAssignment_4_0(), "rule__ProcessStatusExpression__ActiveAssignment_4_0");
			builder.put(grammarAccess.getProcessStatusExpressionAccess().getInactiveAssignment_4_1(), "rule__ProcessStatusExpression__InactiveAssignment_4_1");
			builder.put(grammarAccess.getProcessStatusExpressionAccess().getStopAssignment_4_2(), "rule__ProcessStatusExpression__StopAssignment_4_2");
			builder.put(grammarAccess.getProcessStatusExpressionAccess().getErrorAssignment_4_3(), "rule__ProcessStatusExpression__ErrorAssignment_4_3");
			builder.put(grammarAccess.getStartProcessStatementAccess().getProcessAssignment_0_1_2(), "rule__StartProcessStatement__ProcessAssignment_0_1_2");
			builder.put(grammarAccess.getStopProcessStatementAccess().getProcessAssignment_2_1(), "rule__StopProcessStatement__ProcessAssignment_2_1");
			builder.put(grammarAccess.getErrorProcessStatementAccess().getProcessAssignment_2_1(), "rule__ErrorProcessStatement__ProcessAssignment_2_1");
			builder.put(grammarAccess.getTimeoutStatementAccess().getConstAssignment_1_0(), "rule__TimeoutStatement__ConstAssignment_1_0");
			builder.put(grammarAccess.getTimeoutStatementAccess().getVariableAssignment_1_1(), "rule__TimeoutStatement__VariableAssignment_1_1");
			builder.put(grammarAccess.getTimeoutStatementAccess().getStatementAssignment_3(), "rule__TimeoutStatement__StatementAssignment_3");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_2(), "rule__Expression__RightAssignment_1_2");
			builder.put(grammarAccess.getXorExpressionAccess().getRightAssignment_1_2(), "rule__XorExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2(), "rule__AndExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getCompExpressionAccess().getCompOpAssignment_1_1(), "rule__CompExpression__CompOpAssignment_1_1");
			builder.put(grammarAccess.getCompExpressionAccess().getRightAssignment_1_2(), "rule__CompExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getEquExpressionAccess().getEquOpAssignment_1_1(), "rule__EquExpression__EquOpAssignment_1_1");
			builder.put(grammarAccess.getEquExpressionAccess().getRightAssignment_1_2(), "rule__EquExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getAddExpressionAccess().getAddOpAssignment_1_1(), "rule__AddExpression__AddOpAssignment_1_1");
			builder.put(grammarAccess.getAddExpressionAccess().getRightAssignment_1_2(), "rule__AddExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getMulExpressionAccess().getMulOpAssignment_1_1(), "rule__MulExpression__MulOpAssignment_1_1");
			builder.put(grammarAccess.getMulExpressionAccess().getRightAssignment_1_2(), "rule__MulExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getPowerExpressionAccess().getRightAssignment_1_2(), "rule__PowerExpression__RightAssignment_1_2");
			builder.put(grammarAccess.getUnaryExpressionAccess().getUnOpAssignment_1_0(), "rule__UnaryExpression__UnOpAssignment_1_0");
			builder.put(grammarAccess.getUnaryExpressionAccess().getRightAssignment_1_1(), "rule__UnaryExpression__RightAssignment_1_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getConstAssignment_0(), "rule__PrimaryExpression__ConstAssignment_0");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getVariableAssignment_1(), "rule__PrimaryExpression__VariableAssignment_1");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getArrayAssignment_2(), "rule__PrimaryExpression__ArrayAssignment_2");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getProcStatusAssignment_3(), "rule__PrimaryExpression__ProcStatusAssignment_3");
			builder.put(grammarAccess.getPrimaryExpressionAccess().getNestExprAssignment_4_1(), "rule__PrimaryExpression__NestExprAssignment_4_1");
			builder.put(grammarAccess.getStatementListAccess().getStatementsAssignment_1(), "rule__StatementList__StatementsAssignment_1");
			builder.put(grammarAccess.getAssignmentStatementAccess().getVariableAssignment_0_0(), "rule__AssignmentStatement__VariableAssignment_0_0");
			builder.put(grammarAccess.getAssignmentStatementAccess().getArrayAssignment_0_1(), "rule__AssignmentStatement__ArrayAssignment_0_1");
			builder.put(grammarAccess.getAssignmentStatementAccess().getValueAssignment_2(), "rule__AssignmentStatement__ValueAssignment_2");
			builder.put(grammarAccess.getIfStatementAccess().getMainCondAssignment_1(), "rule__IfStatement__MainCondAssignment_1");
			builder.put(grammarAccess.getIfStatementAccess().getMainStatementAssignment_3(), "rule__IfStatement__MainStatementAssignment_3");
			builder.put(grammarAccess.getIfStatementAccess().getElseIfCondAssignment_4_1(), "rule__IfStatement__ElseIfCondAssignment_4_1");
			builder.put(grammarAccess.getIfStatementAccess().getElseIfStatementsAssignment_4_3(), "rule__IfStatement__ElseIfStatementsAssignment_4_3");
			builder.put(grammarAccess.getIfStatementAccess().getElseStatementAssignment_5_1(), "rule__IfStatement__ElseStatementAssignment_5_1");
			builder.put(grammarAccess.getCaseStatementAccess().getCondAssignment_1(), "rule__CaseStatement__CondAssignment_1");
			builder.put(grammarAccess.getCaseStatementAccess().getCaseElementsAssignment_3(), "rule__CaseStatement__CaseElementsAssignment_3");
			builder.put(grammarAccess.getCaseStatementAccess().getElseStatementAssignment_4_1(), "rule__CaseStatement__ElseStatementAssignment_4_1");
			builder.put(grammarAccess.getCaseElementAccess().getCaseListAssignment_0(), "rule__CaseElement__CaseListAssignment_0");
			builder.put(grammarAccess.getCaseElementAccess().getStatementAssignment_2(), "rule__CaseElement__StatementAssignment_2");
			builder.put(grammarAccess.getCaseListAccess().getCaseListElementAssignment_0(), "rule__CaseList__CaseListElementAssignment_0");
			builder.put(grammarAccess.getCaseListAccess().getCaseListElementAssignment_1_1(), "rule__CaseList__CaseListElementAssignment_1_1");
			builder.put(grammarAccess.getForStatementAccess().getVariableAssignment_1(), "rule__ForStatement__VariableAssignment_1");
			builder.put(grammarAccess.getForStatementAccess().getForListAssignment_3(), "rule__ForStatement__ForListAssignment_3");
			builder.put(grammarAccess.getForStatementAccess().getStatementAssignment_5(), "rule__ForStatement__StatementAssignment_5");
			builder.put(grammarAccess.getForListAccess().getStartAssignment_0(), "rule__ForList__StartAssignment_0");
			builder.put(grammarAccess.getForListAccess().getEndAssignment_2(), "rule__ForList__EndAssignment_2");
			builder.put(grammarAccess.getForListAccess().getStepAssignment_3_1(), "rule__ForList__StepAssignment_3_1");
			builder.put(grammarAccess.getWhileStatementAccess().getCondAssignment_1(), "rule__WhileStatement__CondAssignment_1");
			builder.put(grammarAccess.getWhileStatementAccess().getStatementAssignment_3(), "rule__WhileStatement__StatementAssignment_3");
			builder.put(grammarAccess.getRepeatStatementAccess().getStatementAssignment_1(), "rule__RepeatStatement__StatementAssignment_1");
			builder.put(grammarAccess.getRepeatStatementAccess().getCondAssignment_3(), "rule__RepeatStatement__CondAssignment_3");
			builder.put(grammarAccess.getArrayVariableAccess().getVarNameAssignment_0(), "rule__ArrayVariable__VarNameAssignment_0");
			builder.put(grammarAccess.getArrayVariableAccess().getIndexAssignment_2(), "rule__ArrayVariable__IndexAssignment_2");
			builder.put(grammarAccess.getSymbolicVariableAccess().getNameAssignment(), "rule__SymbolicVariable__NameAssignment");
			builder.put(grammarAccess.getVarInitDeclarationAccess().getVarListAssignment_0(), "rule__VarInitDeclaration__VarListAssignment_0");
			builder.put(grammarAccess.getVarInitDeclarationAccess().getSpecAssignment_2_0(), "rule__VarInitDeclaration__SpecAssignment_2_0");
			builder.put(grammarAccess.getVarInitDeclarationAccess().getArrSpecAssignment_2_1(), "rule__VarInitDeclaration__ArrSpecAssignment_2_1");
			builder.put(grammarAccess.getVarListAccess().getVarsAssignment_0(), "rule__VarList__VarsAssignment_0");
			builder.put(grammarAccess.getVarListAccess().getVarsAssignment_1_1(), "rule__VarList__VarsAssignment_1_1");
			builder.put(grammarAccess.getInputVarDeclarationAccess().getVarsAssignment_1_0(), "rule__InputVarDeclaration__VarsAssignment_1_0");
			builder.put(grammarAccess.getOutputVarDeclarationAccess().getVarsAssignment_1_0(), "rule__OutputVarDeclaration__VarsAssignment_1_0");
			builder.put(grammarAccess.getInputOutputVarDeclarationAccess().getVarsAssignment_1_0(), "rule__InputOutputVarDeclaration__VarsAssignment_1_0");
			builder.put(grammarAccess.getVarDeclarationAccess().getConstAssignment_1(), "rule__VarDeclaration__ConstAssignment_1");
			builder.put(grammarAccess.getVarDeclarationAccess().getVarsAssignment_2_0(), "rule__VarDeclaration__VarsAssignment_2_0");
			builder.put(grammarAccess.getTempVarDeclarationAccess().getVarsAssignment_1_0(), "rule__TempVarDeclaration__VarsAssignment_1_0");
			builder.put(grammarAccess.getExternalVarDeclarationAccess().getConstAssignment_1(), "rule__ExternalVarDeclaration__ConstAssignment_1");
			builder.put(grammarAccess.getExternalVarDeclarationAccess().getVarsAssignment_2_0(), "rule__ExternalVarDeclaration__VarsAssignment_2_0");
			builder.put(grammarAccess.getExternalVarInitDeclarationAccess().getVarListAssignment_0(), "rule__ExternalVarInitDeclaration__VarListAssignment_0");
			builder.put(grammarAccess.getExternalVarInitDeclarationAccess().getTypeAssignment_2(), "rule__ExternalVarInitDeclaration__TypeAssignment_2");
			builder.put(grammarAccess.getGlobalVarDeclarationAccess().getConstAssignment_1(), "rule__GlobalVarDeclaration__ConstAssignment_1");
			builder.put(grammarAccess.getGlobalVarDeclarationAccess().getVarsSimpleAssignment_2_0_0(), "rule__GlobalVarDeclaration__VarsSimpleAssignment_2_0_0");
			builder.put(grammarAccess.getGlobalVarDeclarationAccess().getVarsAsAssignment_2_1_0(), "rule__GlobalVarDeclaration__VarsAsAssignment_2_1_0");
			builder.put(grammarAccess.getGlobalVarInitDeclarationAccess().getVarListAssignment_0(), "rule__GlobalVarInitDeclaration__VarListAssignment_0");
			builder.put(grammarAccess.getGlobalVarInitDeclarationAccess().getLocationAssignment_2(), "rule__GlobalVarInitDeclaration__LocationAssignment_2");
			builder.put(grammarAccess.getGlobalVarInitDeclarationAccess().getTypeAssignment_4(), "rule__GlobalVarInitDeclaration__TypeAssignment_4");
			builder.put(grammarAccess.getArraySpecInitAccess().getInitAssignment_0(), "rule__ArraySpecInit__InitAssignment_0");
			builder.put(grammarAccess.getArraySpecInitAccess().getValuesAssignment_1_1(), "rule__ArraySpecInit__ValuesAssignment_1_1");
			builder.put(grammarAccess.getArraySpecificationAccess().getStartAssignment_2(), "rule__ArraySpecification__StartAssignment_2");
			builder.put(grammarAccess.getArraySpecificationAccess().getEndAssignment_4(), "rule__ArraySpecification__EndAssignment_4");
			builder.put(grammarAccess.getArraySpecificationAccess().getTypeAssignment_7(), "rule__ArraySpecification__TypeAssignment_7");
			builder.put(grammarAccess.getArrayInitializationAccess().getElementsAssignment_1(), "rule__ArrayInitialization__ElementsAssignment_1");
			builder.put(grammarAccess.getArrayInitializationAccess().getElementsAssignment_2_1(), "rule__ArrayInitialization__ElementsAssignment_2_1");
			builder.put(grammarAccess.getTimeLiteralAccess().getIntervalAssignment_3(), "rule__TimeLiteral__IntervalAssignment_3");
			builder.put(grammarAccess.getSimpleSpecificationInitAccess().getTypeAssignment_1(), "rule__SimpleSpecificationInit__TypeAssignment_1");
			builder.put(grammarAccess.getSimpleSpecificationInitAccess().getValueAssignment_2_1(), "rule__SimpleSpecificationInit__ValueAssignment_2_1");
			builder.put(grammarAccess.getSignedIntegerAccess().getISigAssignment_0(), "rule__SignedInteger__ISigAssignment_0");
			builder.put(grammarAccess.getSignedIntegerAccess().getValueAssignment_1(), "rule__SignedInteger__ValueAssignment_1");
			builder.put(grammarAccess.getIntegerLiteralAccess().getTypeAssignment_0_0(), "rule__IntegerLiteral__TypeAssignment_0_0");
			builder.put(grammarAccess.getIntegerLiteralAccess().getValueAssignment_1(), "rule__IntegerLiteral__ValueAssignment_1");
			builder.put(grammarAccess.getRealLiteralAccess().getTypeAssignment_0_0(), "rule__RealLiteral__TypeAssignment_0_0");
			builder.put(grammarAccess.getRealLiteralAccess().getRSigAssignment_1(), "rule__RealLiteral__RSigAssignment_1");
			builder.put(grammarAccess.getRealLiteralAccess().getValueAssignment_2(), "rule__RealLiteral__ValueAssignment_2");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private PoSTGrammarAccess grammarAccess;

	@Override
	protected InternalPoSTParser createParser() {
		InternalPoSTParser result = new InternalPoSTParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public PoSTGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PoSTGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
