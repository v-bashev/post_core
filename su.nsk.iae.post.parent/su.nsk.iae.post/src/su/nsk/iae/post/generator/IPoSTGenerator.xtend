package su.nsk.iae.post.generator

import su.nsk.iae.post.poST.Model
import org.eclipse.xtext.generator.IGenerator2

interface IPoSTGenerator extends IGenerator2 {
	def void setModel(Model model)	
}