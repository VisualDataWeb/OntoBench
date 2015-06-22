/*
 * Exporter.java
 *
 */

package de.linkvt.bachelor.output;

/**
 * Exports the passed object.
 */
public interface Exporter {
	void export(Object object) throws Exception;
}
