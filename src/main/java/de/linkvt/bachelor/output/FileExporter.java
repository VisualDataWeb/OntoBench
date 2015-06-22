/*
 * FileExporter.java
 *
 */

package de.linkvt.bachelor.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Exports the passed value into a file.
 */
public class FileExporter implements Exporter {
	private File destinationFile;

	public FileExporter(File destination) {
		this.destinationFile = destination;
	}

	@Override public void export(Object object) throws IOException {
		try (FileWriter writer = new FileWriter(destinationFile)) {
			writer.write(object.toString());
		}
	}
}
