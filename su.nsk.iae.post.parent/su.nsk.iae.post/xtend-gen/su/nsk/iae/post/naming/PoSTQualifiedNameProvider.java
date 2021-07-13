package su.nsk.iae.post.naming;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import su.nsk.iae.post.poST.FunctionBlock;
import su.nsk.iae.post.poST.InputOutputVarDeclaration;
import su.nsk.iae.post.poST.InputVarDeclaration;
import su.nsk.iae.post.poST.OutputVarDeclaration;
import su.nsk.iae.post.poST.Program;
import su.nsk.iae.post.poST.SymbolicVariable;
import su.nsk.iae.post.poST.TempVarDeclaration;
import su.nsk.iae.post.poST.VarDeclaration;
import su.nsk.iae.post.poST.VarInitDeclaration;

@SuppressWarnings("all")
public class PoSTQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
  public QualifiedName qualifiedPoSTName(final Object ele) {
    return this.qualifiedName(ele);
  }
  
  @Override
  protected QualifiedName qualifiedName(final Object ele) {
    if ((ele instanceof SymbolicVariable)) {
      boolean _checkVarInitDeclaration = this.checkVarInitDeclaration(((EObject)ele));
      if (_checkVarInitDeclaration) {
        return this.varInitDeclarationQualifiedName(((SymbolicVariable)ele));
      }
    }
    if ((ele instanceof su.nsk.iae.post.poST.Process)) {
      this.processQualifiedName(((su.nsk.iae.post.poST.Process)ele));
    }
    return super.qualifiedName(ele);
  }
  
  private boolean checkVarInitDeclaration(final EObject ele) {
    VarInitDeclaration _containerOfType = EcoreUtil2.<VarInitDeclaration>getContainerOfType(ele, VarInitDeclaration.class);
    return (_containerOfType != null);
  }
  
  private QualifiedName varInitDeclarationQualifiedName(final SymbolicVariable ele) {
    final Program program = EcoreUtil2.<Program>getContainerOfType(ele, Program.class);
    if ((program != null)) {
      final su.nsk.iae.post.poST.Process process = EcoreUtil2.<su.nsk.iae.post.poST.Process>getContainerOfType(ele, su.nsk.iae.post.poST.Process.class);
      if ((process != null)) {
        return QualifiedName.create(program.getName(), process.getName(), ele.getName());
      }
      return QualifiedName.create(program.getName(), ele.getName());
    }
    return QualifiedName.create(ele.getName());
  }
  
  private QualifiedName processQualifiedName(final su.nsk.iae.post.poST.Process ele) {
    final Program program = EcoreUtil2.<Program>getContainerOfType(ele, Program.class);
    return QualifiedName.create(program.getName(), ele.getName());
  }
  
  public static boolean checkProcesses(final Program program, final String eleName) {
    final Predicate<su.nsk.iae.post.poST.Process> _function = (su.nsk.iae.post.poST.Process x) -> {
      return x.getName().equals(eleName);
    };
    return program.getProcesses().stream().anyMatch(_function);
  }
  
  public static boolean checkProcesses(final FunctionBlock program, final String eleName) {
    final Predicate<su.nsk.iae.post.poST.Process> _function = (su.nsk.iae.post.poST.Process x) -> {
      return x.getName().equals(eleName);
    };
    return program.getProcesses().stream().anyMatch(_function);
  }
  
  public static boolean checkProgramVars(final Program program, final String eleName) {
    return (Stream.<EList<SymbolicVariable>>concat(
      program.getProgVars().stream().<EList<VarInitDeclaration>>map(((Function<VarDeclaration, EList<VarInitDeclaration>>) (VarDeclaration x) -> {
        return x.getVars();
      })).<VarInitDeclaration>flatMap(((Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>>) (EList<VarInitDeclaration> x) -> {
        return x.stream();
      })).<EList<SymbolicVariable>>map(((Function<VarInitDeclaration, EList<SymbolicVariable>>) (VarInitDeclaration x) -> {
        return x.getVarList().getVars();
      })), 
      program.getProgTempVars().stream().<EList<VarInitDeclaration>>map(((Function<TempVarDeclaration, EList<VarInitDeclaration>>) (TempVarDeclaration x) -> {
        return x.getVars();
      })).<VarInitDeclaration>flatMap(((Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>>) (EList<VarInitDeclaration> x) -> {
        return x.stream();
      })).<EList<SymbolicVariable>>map(((Function<VarInitDeclaration, EList<SymbolicVariable>>) (VarInitDeclaration x) -> {
        return x.getVarList().getVars();
      }))).<SymbolicVariable>flatMap(((Function<EList<SymbolicVariable>, Stream<SymbolicVariable>>) (EList<SymbolicVariable> x) -> {
      return x.stream();
    })).anyMatch(((Predicate<SymbolicVariable>) (SymbolicVariable x) -> {
      return x.getName().equals(eleName);
    })) || PoSTQualifiedNameProvider.checkProgramInOutVars(program, eleName));
  }
  
  public static boolean checkProgramInOutVars(final Program program, final String eleName) {
    final Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_3 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_6 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_7 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_8 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    final Predicate<SymbolicVariable> _function_10 = (SymbolicVariable x) -> {
      return x.getName().equals(eleName);
    };
    return Stream.<EList<SymbolicVariable>>concat(
      program.getProgInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        program.getProgOutVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        program.getProgInOutVars().stream().<EList<VarInitDeclaration>>map(_function_6).<VarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).anyMatch(_function_10);
  }
  
  public static boolean checFBVars(final FunctionBlock fb, final String eleName) {
    return (Stream.<EList<SymbolicVariable>>concat(
      fb.getFbVars().stream().<EList<VarInitDeclaration>>map(((Function<VarDeclaration, EList<VarInitDeclaration>>) (VarDeclaration x) -> {
        return x.getVars();
      })).<VarInitDeclaration>flatMap(((Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>>) (EList<VarInitDeclaration> x) -> {
        return x.stream();
      })).<EList<SymbolicVariable>>map(((Function<VarInitDeclaration, EList<SymbolicVariable>>) (VarInitDeclaration x) -> {
        return x.getVarList().getVars();
      })), 
      fb.getFbTempVars().stream().<EList<VarInitDeclaration>>map(((Function<TempVarDeclaration, EList<VarInitDeclaration>>) (TempVarDeclaration x) -> {
        return x.getVars();
      })).<VarInitDeclaration>flatMap(((Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>>) (EList<VarInitDeclaration> x) -> {
        return x.stream();
      })).<EList<SymbolicVariable>>map(((Function<VarInitDeclaration, EList<SymbolicVariable>>) (VarInitDeclaration x) -> {
        return x.getVarList().getVars();
      }))).<SymbolicVariable>flatMap(((Function<EList<SymbolicVariable>, Stream<SymbolicVariable>>) (EList<SymbolicVariable> x) -> {
      return x.stream();
    })).anyMatch(((Predicate<SymbolicVariable>) (SymbolicVariable x) -> {
      return x.getName().equals(eleName);
    })) || PoSTQualifiedNameProvider.checkFBInOutVars(fb, eleName));
  }
  
  public static boolean checkFBInOutVars(final FunctionBlock fb, final String eleName) {
    final Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_3 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_6 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_7 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_8 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    final Predicate<SymbolicVariable> _function_10 = (SymbolicVariable x) -> {
      return x.getName().equals(eleName);
    };
    return Stream.<EList<SymbolicVariable>>concat(
      fb.getFbInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        fb.getFbOutVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        fb.getFbInOutVars().stream().<EList<VarInitDeclaration>>map(_function_6).<VarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).anyMatch(_function_10);
  }
  
  public static boolean checkProcessVars(final su.nsk.iae.post.poST.Process process, final String eleName) {
    return (Stream.<EList<SymbolicVariable>>concat(
      process.getProcVars().stream().<EList<VarInitDeclaration>>map(((Function<VarDeclaration, EList<VarInitDeclaration>>) (VarDeclaration x) -> {
        return x.getVars();
      })).<VarInitDeclaration>flatMap(((Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>>) (EList<VarInitDeclaration> x) -> {
        return x.stream();
      })).<EList<SymbolicVariable>>map(((Function<VarInitDeclaration, EList<SymbolicVariable>>) (VarInitDeclaration x) -> {
        return x.getVarList().getVars();
      })), 
      process.getProcTempVars().stream().<EList<VarInitDeclaration>>map(((Function<TempVarDeclaration, EList<VarInitDeclaration>>) (TempVarDeclaration x) -> {
        return x.getVars();
      })).<VarInitDeclaration>flatMap(((Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>>) (EList<VarInitDeclaration> x) -> {
        return x.stream();
      })).<EList<SymbolicVariable>>map(((Function<VarInitDeclaration, EList<SymbolicVariable>>) (VarInitDeclaration x) -> {
        return x.getVarList().getVars();
      }))).<SymbolicVariable>flatMap(((Function<EList<SymbolicVariable>, Stream<SymbolicVariable>>) (EList<SymbolicVariable> x) -> {
      return x.stream();
    })).anyMatch(((Predicate<SymbolicVariable>) (SymbolicVariable x) -> {
      return x.getName().equals(eleName);
    })) || PoSTQualifiedNameProvider.checkProcessInOutVars(process, eleName));
  }
  
  public static boolean checkProcessInOutVars(final su.nsk.iae.post.poST.Process process, final String eleName) {
    final Function<InputVarDeclaration, EList<VarInitDeclaration>> _function = (InputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_1 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_2 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<OutputVarDeclaration, EList<VarInitDeclaration>> _function_3 = (OutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_4 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_5 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<InputOutputVarDeclaration, EList<VarInitDeclaration>> _function_6 = (InputOutputVarDeclaration x) -> {
      return x.getVars();
    };
    final Function<EList<VarInitDeclaration>, Stream<VarInitDeclaration>> _function_7 = (EList<VarInitDeclaration> x) -> {
      return x.stream();
    };
    final Function<VarInitDeclaration, EList<SymbolicVariable>> _function_8 = (VarInitDeclaration x) -> {
      return x.getVarList().getVars();
    };
    final Function<EList<SymbolicVariable>, Stream<SymbolicVariable>> _function_9 = (EList<SymbolicVariable> x) -> {
      return x.stream();
    };
    final Predicate<SymbolicVariable> _function_10 = (SymbolicVariable x) -> {
      return x.getName().equals(eleName);
    };
    return Stream.<EList<SymbolicVariable>>concat(
      process.getProcInVars().stream().<EList<VarInitDeclaration>>map(_function).<VarInitDeclaration>flatMap(_function_1).<EList<SymbolicVariable>>map(_function_2), 
      Stream.<EList<SymbolicVariable>>concat(
        process.getProcOutVars().stream().<EList<VarInitDeclaration>>map(_function_3).<VarInitDeclaration>flatMap(_function_4).<EList<SymbolicVariable>>map(_function_5), 
        process.getProcInOutVars().stream().<EList<VarInitDeclaration>>map(_function_6).<VarInitDeclaration>flatMap(_function_7).<EList<SymbolicVariable>>map(_function_8))).<SymbolicVariable>flatMap(_function_9).anyMatch(_function_10);
  }
}
