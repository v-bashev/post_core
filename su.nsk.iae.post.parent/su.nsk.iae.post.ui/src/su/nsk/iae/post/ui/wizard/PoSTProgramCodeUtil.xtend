package su.nsk.iae.post.ui.wizard

class PoSTProgramCodeUtil {
	static def String getTeplateProgram() '''
		CONFIGURATION Conf
		
			RESOURCE Res1 ON TestCPU
		
				TASK T1 (INTERVAL := T#100ms, PRIORITY := 1);
		
				PROGRAM p1 WITH T1 : Program1;
		
			END_RESOURCE
		
		END_CONFIGURATION
		
		PROGRAM Program1
		
		    PROCESS Process1
		
		        STATE State1
		            
		        END_STATE
		
		    END_PROCESS
		
		END_PROGRAM
	'''
	
	static def String getHandDryerProgram() '''
		CONFIGURATION Conf
		
			RESOURCE Res1 ON TestCPU
		
				TASK T1 (INTERVAL := T#100ms, PRIORITY := 1);
		
				PROGRAM dryer WITH T1 : HandDryer;
		
			END_RESOURCE
		
		END_CONFIGURATION
		
		PROGRAM HandDryer
		
		    VAR_INPUT
		        hands : BOOL;
		    END_VAR
		
		    VAR_OUTPUT
		        control : BOOL;
		    END_VAR
		
		    PROCESS Dry
		
		        STATE Wait
		            IF hands THEN
		                control := TRUE;
		                SET NEXT;
		            END_IF
		        END_STATE
		
		        STATE Work
		            IF hands THEN
		                RESET TIMER;
		            END_IF
		            TIMEOUT T#2s THEN
		                control := FALSE;
		                SET STATE Wait;
		            END_TIMEOUT
		        END_STATE
		
		    END_PROCESS
		
		END_PROGRAM
	'''
}