/*
 * ConsoleExporter.java
 *
 */

package de.linkvt.bachelor.output;

/**
 * Exports the passed value to the console.
 */
public class ConsoleExporter implements Exporter {
	@Override public void export(Object object) {
		System.out.println(object);
	}
}
