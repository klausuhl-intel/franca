/*
 * generated by Xtext
 */
package org.franca.deploymodel.dsl.formatting;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.franca.deploymodel.dsl.services.FDeployGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class FDeployFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		FDeployGrammarAccess f = (FDeployGrammarAccess) getGrammarAccess();
		
		// add newlines around comments
		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());
		

		c.setLinewrap(1).around(f.getImportRule());
		c.setLinewrap(2).before(f.getFDSpecificationRule());
		c.setLinewrap(2).before(f.getFDInterfaceRule());
		c.setLinewrap(2).around(f.getFDMethodRule());
		
		// generic formatting of curly bracket sections
		for(Pair<Keyword, Keyword> pair: f.findKeywordPairs("{", "}")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
//			c.setIndentation(pair.getFirst(), pair.getSecond());
			c.setLinewrap(1).after(pair.getFirst());
			c.setLinewrap(1).before(pair.getSecond());
			c.setLinewrap(1).after(pair.getSecond());
		}

		// property lists
		c.setLinewrap(1).around(f.getFDPropertyRule());

	}
}
