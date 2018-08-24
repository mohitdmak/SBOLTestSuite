package ValidationTesting;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;

import org.sbolstandard.core2.SBOLConversionException;
import org.sbolstandard.core2.SBOLDocument;
import org.sbolstandard.core2.SBOLReader;
import org.sbolstandard.core2.SBOLValidate;
import org.sbolstandard.core2.SBOLValidationException;
import org.sbolstandard.core2.SBOLWriter;

import static org.junit.Assert.*;

/**
 * Checks a set of SBOL files in which each should fail a particular validation
 * rule.
 * 
 * @author Meher Samineni
 * @author Chris Myers
 *
 */
@RunWith(Enclosed.class)
public class SBOL2ValidationTest {

	@RunWith(Parameterized.class)
	public static class SBOL2False {
		private File file;

		/**
		 * @param file
		 *            - file to test
		 */
		public SBOL2False(File file) {
			this.file = file;
		}

		/**
		 * @return a set of files to test
		 */
		@Parameterized.Parameters
		public static java.util.Collection<File> files() {
			File file_base = null;
			java.util.Collection<File> col = new HashSet<File>();

			file_base = new File("../SBOLTestSuite/SBOL2/");

			for (File f : file_base.listFiles()) {
				col.add(f);
			}

			return col;
		}

		/**
		 * Run each xml/XML file under the "Validation" sub-directory to test SBOL
		 * validation exceptions.
		 * 
		 * @throws IOException
		 *             see {@link IOException}
		 * @throws SBOLConversionException
		 *             see {@link SBOLConversionException}
		 * @throws SBOLValidationException
		 *             see {@link SBOLValidationException}
		 */
		@Test
		public void runValidation()
				throws IOException, SBOLConversionException, SBOLValidationException {
			SBOLReader.setKeepGoing(true);
			SBOLDocument doc = SBOLReader.read(file);
			SBOLValidate.validateSBOL(doc, false, false, false);

			if (SBOLReader.getNumErrors() > 0 || SBOLValidate.getNumErrors() > 0) {
				System.out.println("Testing " + file.getName() + ": ");
				// String fileName = dir + "/" + file.getName();
				// SBOLWriter.write(doc, fileName);
				// String errorFileName = dir + "/" + file.getName().replace(".xml", "") +
				// "_errors.txt";
				// BufferedWriter bw = new BufferedWriter(new FileWriter(new
				// File(errorFileName)));

				for (String error : SBOLReader.getErrors()) {
					System.out.println(error);
					// bw.write(error);
					// bw.write("\n");
				}


				for (String error : SBOLValidate.getErrors()) {
					System.out.println(error);

					// bw.write(error);
					// bw.write("\n");
				}

				// bw.close();
				fail();
			}
		}

	}

	@RunWith(Parameterized.class)
	public static class SBOL2IC {
		private File file;

		/**
		 * @param file
		 *            - file to test
		 */
		public SBOL2IC(File file) {
			this.file = file;
		}

		/**
		 * @return a set of files to test
		 */
		@Parameterized.Parameters
		public static java.util.Collection<File> files() {
			File file_base = null;
			java.util.Collection<File> col = new HashSet<File>();

			file_base = new File("../SBOLTestSuite/SBOL2_ic/");

			for (File f : file_base.listFiles()) {
				col.add(f);
			}

			return col;
		}

		/**
		 * Run each xml/XML file under the "Validation" sub-directory to test SBOL
		 * validation exceptions.
		 * 
		 * @throws IOException
		 *             see {@link IOException}
		 * @throws SBOLConversionException
		 *             see {@link SBOLConversionException}
		 * @throws SBOLValidationException
		 *             see {@link SBOLValidationException}
		 */
		@Test
		public void runValidation()
				throws IOException, SBOLConversionException, SBOLValidationException {
			SBOLReader.setKeepGoing(true);
			SBOLDocument doc = SBOLReader.read(file);
			SBOLValidate.validateSBOL(doc, true, false, false);

			if (SBOLReader.getNumErrors() > 0 || SBOLValidate.getNumErrors() > 0) {
				System.out.println("Testing " + file.getName() + ": ");
				// String fileName = dir + "/" + file.getName();
				// SBOLWriter.write(doc, fileName);
				// String errorFileName = dir + "/" + file.getName().replace(".xml", "") +
				// "_errors.txt";
				// BufferedWriter bw = new BufferedWriter(new FileWriter(new
				// File(errorFileName)));

				for (String error : SBOLReader.getErrors()) {
					System.out.println(error);
					// bw.write(error);
					// bw.write("\n");
				}

				for (String error : SBOLValidate.getErrors()) {
					System.out.println(error);

					// bw.write(error);
					// bw.write("\n");
				}

				// bw.close();
				fail();
			}
		}

	}

	@RunWith(Parameterized.class)
	public static class SBOL2NC {
		private File file;

		/**
		 * @param file
		 *            - file to test
		 */
		public SBOL2NC(File file) {
			this.file = file;
		}

		/**
		 * @return a set of files to test
		 */
		@Parameterized.Parameters
		public static java.util.Collection<File> files() {
			File file_base = null;
			java.util.Collection<File> col = new HashSet<File>();

			file_base = new File("../SBOLTestSuite/SBOL2_nc/");

			for (File f : file_base.listFiles()) {
				col.add(f);
			}

			return col;
		}

		/**
		 * Run each xml/XML file under the "Validation" sub-directory to test SBOL
		 * validation exceptions.
		 * 
		 * @throws IOException
		 *             see {@link IOException}
		 * @throws SBOLConversionException
		 *             see {@link SBOLConversionException}
		 * @throws SBOLValidationException
		 *             see {@link SBOLValidationException}
		 */
		@Test
		public void runValidation()
				throws IOException, SBOLConversionException, SBOLValidationException {
			SBOLReader.setKeepGoing(true);
			SBOLDocument doc = SBOLReader.read(file);
			SBOLValidate.validateSBOL(doc, false, true, false);

			if (SBOLReader.getNumErrors() > 0 || SBOLValidate.getNumErrors() > 0) {
				System.out.println("Testing " + file.getName() + ": ");
				// String fileName = dir + "/" + file.getName();
				// SBOLWriter.write(doc, fileName);
				// String errorFileName = dir + "/" + file.getName().replace(".xml", "") +
				// "_errors.txt";
				// BufferedWriter bw = new BufferedWriter(new FileWriter(new
				// File(errorFileName)));

				for (String error : SBOLReader.getErrors()) {
					System.out.println(error);
					// bw.write(error);
					// bw.write("\n");
				}

				for (String error : SBOLValidate.getErrors()) {
					System.out.println(error);

					// bw.write(error);
					// bw.write("\n");
				}

				// bw.close();
				fail();
			}
		}

	}

	@RunWith(Parameterized.class)
	public static class SBOL2BP {
		private File file;

		/**
		 * @param file
		 *            - file to test
		 */
		public SBOL2BP(File file) {
			this.file = file;
		}

		/**
		 * @return a set of files to test
		 */
		@Parameterized.Parameters
		public static java.util.Collection<File> files() {
			File file_base = null;
			java.util.Collection<File> col = new HashSet<File>();

			file_base = new File("../SBOLTestSuite/SBOL2_bp/");

			for (File f : file_base.listFiles()) {
				col.add(f);
			}

			return col;
		}

		/**
		 * Run each xml/XML file under the "Validation" sub-directory to test SBOL
		 * validation exceptions.
		 * 
		 * @throws IOException
		 *             see {@link IOException}
		 * @throws SBOLConversionException
		 *             see {@link SBOLConversionException}
		 * @throws SBOLValidationException
		 *             see {@link SBOLValidationException}
		 */
		@Test
		public void runValidation()
				throws IOException, SBOLConversionException, SBOLValidationException {
			SBOLReader.setKeepGoing(true);
			SBOLDocument doc = SBOLReader.read(file);
			SBOLValidate.validateSBOL(doc, false, false, true);

			if (SBOLReader.getNumErrors() > 0 || SBOLValidate.getNumErrors() > 0) {
				System.out.println("Testing " + file.getName() + ": ");
				// String fileName = dir + "/" + file.getName();
				// SBOLWriter.write(doc, fileName);
				// String errorFileName = dir + "/" + file.getName().replace(".xml", "") +
				// "_errors.txt";
				// BufferedWriter bw = new BufferedWriter(new FileWriter(new
				// File(errorFileName)));

				for (String error : SBOLReader.getErrors()) {
					System.out.println(error);
					// bw.write(error);
					// bw.write("\n");
				}

				for (String error : SBOLValidate.getErrors()) {
					System.out.println(error);

					// bw.write(error);
					// bw.write("\n");
				}

				// bw.close();
				fail();
			}
		}

	}

}
