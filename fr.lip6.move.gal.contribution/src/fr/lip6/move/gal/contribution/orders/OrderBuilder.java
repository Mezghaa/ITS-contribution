package fr.lip6.move.gal.contribution.orders;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import fr.lip6.move.gal.Specification;
import fr.lip6.move.gal.semantics.INextBuilder;

public class OrderBuilder {
	
	public enum OrderHeuristique {
		Force,
		Sloan
		//TODO
	}
	
	public List<String> buildOrder (Specification spec) {
		INextBuilder inb = INextBuilder.build(spec);
		
		return inb.getVariableNames();		
	}
	
	public List<String> applyHeuristic(Specification spec, List<String> order, OrderHeuristique o) {
		//TODO Appliquer l'ordre ici
		
		return order;
	}

	
	public void printOrder (String path, List<String> order) throws IOException {
		PrintWriter out = new PrintWriter( new BufferedOutputStream(new FileOutputStream(path)));
		out.println("#START\n");
		for (String var : order) {
			out.println(var);
		}
		out.println("#END");
		out.flush();
		out.close();
	}
}
