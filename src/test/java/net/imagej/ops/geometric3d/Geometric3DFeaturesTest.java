package net.imagej.ops.geometric3d;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import net.imagej.ops.Ops.Geometric3D;
import net.imagej.ops.Ops.Geometric3D.ConvexHullSurfaceArea;
import net.imagej.ops.Ops.Geometric3D.ConvexHullSurfacePixel;
import net.imagej.ops.Ops.Geometric3D.Convexity;
import net.imagej.ops.Ops.Geometric3D.Rugosity;
import net.imagej.ops.Ops.Geometric3D.Solidity;
import net.imagej.ops.features.AbstractFeatureTest;
import net.imglib2.roi.labeling.LabelRegion;

import org.junit.Before;
import org.junit.Test;

/**
 * To get comparable values with ImageJ I used the same label as I read in
 * {@link Geometric3DFeaturesTest#createLabelRegion3D()} and did the
 * measurements with the 3D ImageJ Suite
 * (http://imagejdocu.tudor.lu/doku.php?id=plugin:stacks:3d_ij_suite:start).
 * 
 * The Convexhull Volume and Surface Area is tested against qhull (qhull.org).
 * As an input for qhull I used the points generated by MarchingCubes.
 * 
 * @author Tim-Oliver Buchholz, University of Konstanz.
 *
 */
public class Geometric3DFeaturesTest extends AbstractFeatureTest {

	private LabelRegion<String> region;

	@Before
	public void createData() {
		try {
			region = createLabelRegion3D();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test the {@link Solidity} Op.
	 */
	@Test
	public void testSolidity() {
		// This test is just here for completeness.
		// All input values of solidity are verified.
		assertEquals(Geometric3D.Solidity.NAME, 0.902, ops.geometric3d()
				.Solidity(region).get(), AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link Rugosity} Op.
	 */
	@Test
	public void testRugosity() {
		// This test is just here for completeness.
		// All input values of convexity are verified.
		assertEquals(Geometric3D.Rugosity.NAME, 1.099, ops.geometric3d()
				.Rugosity(region).get(), AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link Convexity} Op.
	 */
	@Test
	public void testConvexity() {
		// This test is just here for completeness.
		// All input values of convexity are verified.
		assertEquals(Geometric3D.Convexity.NAME, 0.910, ops.geometric3d()
				.Convexity(region).get(), AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link ConvexHullSurfacePixel} Op.
	 */
	@Test
	public void testConvexHullSurfacePixel() {
		// Verified by hand. qhull merges faces and therefore has another number
		// of
		// surface pixels
		assertEquals(Geometric3D.ConvexHullSurfacePixel.NAME, 616, ops
				.geometric3d().ConvexHullSurfacePixel(region).get(),
				AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link ConvexHullSurfaceArea} Op.
	 */
	@Test
	public void testConvexHullSurfaceArea() {
		// value taken from qhull (qhull.org)
		assertEquals(Geometric3D.ConvexHullSurfaceArea.NAME, 19133.663, ops
				.geometric3d().ConvexHullSurfaceArea(region).get(),
				AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link ConvexHullVolumeFeature} Op.
	 */
	@Test
	public void testConvexHullVolume() {
		// value taken from qhull (qhull.org)
		assertEquals(Geometric3D.ConvexHullVolume.NAME, 234284.5, ops
				.geometric3d().ConvexHullVolume(region).get(),
				AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testSurfaceArea() {
		// value taken from imagej
		// The delta is relatively big because they use float numbers in imagej
		// and my implementation is based on doubles.
		assertEquals(Geometric3D.SurfaceArea.NAME, 21025.018, ops.geometric3d()
				.SurfaceArea(region).get(), 0.186);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testSurfacePixel() {
		// value taken from imagej
		assertEquals(Geometric3D.SurfacePixel.NAME, 29738, ops.geometric3d()
				.SurfacePixel(region).get(), AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testVolume() {
		// value taken from imagej
		assertEquals(Geometric3D.Volume.NAME, 211296,
				ops.geometric3d().Volume(region).get(),
				AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testCompactness() {
		// value taken from imagej
		assertEquals(Geometric3D.Compactness.NAME, 0.192, ops.geometric3d()
				.Compactness(region).get(), AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testSphericity() {
		// value taken from imagej
		assertEquals(Geometric3D.Sphericity.NAME, 0.577, ops.geometric3d()
				.Sphericity(region).get(), AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testMainElongation() {
		// value taken from imagej
		assertEquals(Geometric3D.MainElongation.NAME, 1.312, ops.geometric3d()
				.MainElongation(region).get(), AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testMedianElongation() {
		// value taken from imagej
		assertEquals(Geometric3D.MedianElongation.NAME, 1.126, ops
				.geometric3d().MedianElongation(region).get(),
				AbstractFeatureTest.BIG_DELTA);
	}

	/**
	 * Test the {@link AreaFeature} Op.
	 */
	@Test
	public void testSpareness() {
		// value taken from imagej
		assertEquals(Geometric3D.Spareness.NAME, 0.970, ops.geometric3d()
				.Spareness(region).get(), AbstractFeatureTest.BIG_DELTA);
	}
}
