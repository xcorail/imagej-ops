package net.imagej.ops;

import java.util.List;

import net.imglib2.RandomAccessible;
import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImg;
import net.imglib2.img.basictypeaccess.array.DoubleArray;
import net.imglib2.type.numeric.RealType;
import net.imglib2.type.numeric.real.DoubleType;

import org.junit.Test;

public class GenericsTest {
	public static class Alpha<T extends RealType<T>, I extends Img<T>> {
	  private T t;
	  private I i;
	  private RandomAccessible<T> raT;
	}

	@Test
	public void testStuff() {
		Alpha<DoubleType, ArrayImg<DoubleType, DoubleArray>> alpha = new Alpha<>();
		
		DoubleType dt;
		Img<DoubleType> 
		alpha.t = new DoubleType();
		alpha.i = 
	}

}
