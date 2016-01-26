/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2014 - 2016 Board of Regents of the University of
 * Wisconsin-Madison, University of Konstanz and Brian Northan.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imagej.ops;

import com.google.common.reflect.TypeToken;
import com.googlecode.gentyref.GenericTypeReflector;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import net.imagej.ImageJService;
import net.imagej.ops.Types.Vague;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.Img;
import net.imglib2.type.numeric.RealType;
import net.imglib2.type.numeric.integer.ByteType;
import net.imglib2.type.numeric.integer.GenericByteType;

import org.scijava.service.AbstractService;
import org.scijava.util.ClassUtils;

/**
 * Interface for services that FIXME
 * 
 * @author Curtis Rueden
 */
public class Types extends AbstractService implements ImageJService {

	public static <B extends GenericByteType<B>, T extends RealType<T>> void go() {
		Type destType = exactType("field", Test1.class, Test1.class);
//		Type destType = new TypeToken<Vague<T, Img<T>>>() {}.getType();
//		Type objType = new TypeToken<Vague<B, Img<B>>>() {}.getType();
		TypeToken<Vague<ByteType, Img<ByteType>>> destTT = new TypeToken<Vague<ByteType, Img<ByteType>>>() {};
		TypeToken<Specific> objTT = TypeToken.of(Specific.class);
		Vague<T, Img<T>> destInstance = null;
//		Vague<B, Img<B>> objInstance = null;
		Specific objInstance = null;
		new Test1<ByteType, Img<ByteType>>().field = objInstance;
		System.out.println("GUAVA? " + destTT.isAssignableFrom(objTT));
//		System.out.println("* destination = " + destType);
//		System.out.println("* object = " + objType);
//		new RealThing<T>().fieldToMatch = new Specific();
//		System.out.println("DOES IT WORK? " + fitsInto(Specific.class, destType));
	}

	private static boolean fitsInto(final Object obj, Type destType) {
//		return fitsInto(genericType(obj), destType);
		return fitsInto(obj.getClass(), destType); // obviously insufficient
		// is not good enough, because...
	}

	private static boolean fitsInto(final Type objType, Type destType) {
		// CTR: Unfortunately, this method does not behave as needed.
//		return GenericTypeReflector.isSuperType(destType, objType);
		// NB: We don't need the type to be a "pure" super type (i.e., assignment will work for all possible values of the type variables.
		// We need to be compatible in a "there exists" kind of way: there are values of the type variables which would allow the assignment.

		TypeToken

		/*
		TypeToken.of(destType).where(typeParam, typeArg);
static <K, V> TypeToken<Map<K, V>> mapToken(TypeToken<K> keyToken, TypeToken<V> valueToken) {
  return new TypeToken<Map<K, V>>() {}
    .where(new TypeParameter<K>() {}, keyToken)
    .where(new TypeParameter<V>() {}, valueToken);
}
...
TypeToken<Map<String, BigInteger>> mapToken = mapToken(
   TypeToken.of(String.class),
   TypeToken.of(BigInteger.class));
TypeToken<Map<Integer, Queue<String>>> complexToken = mapToken(
   TypeToken.of(Integer.class),
   new TypeToken<Queue<String>>() {});
	}
    */

	////////////////////////////////

	public static class Vague<T, I extends IterableInterval<T> & RandomAccessibleInterval<T>> {
		//
	}
	public static class Specific extends Vague<ByteType, Img<ByteType>> {
		//
	}

	public static class Test1<T, I extends IterableInterval<T> & RandomAccessibleInterval<T>> {
		public Vague<T, I> field;
	}

	public static void main(final String[] args) {
		// test with type
//		go();

		// test with object
		Specific obj = new Specific();
		new Test1<ByteType, Img<ByteType>>().field = obj;
		Type destType = exactType("field", Test1.class, Test1.class);
		System.out.println(fitsInto(obj, destType));
		if (true) return;

//		System.out.println();
//		System.out.println("== T extends RealType<T> as viewed by I extends IntegerType<I> ==");
//		Field field = ClassUtils.getField(RealThing.class, "realPix");
//		Type t = GenericTypeReflector.getExactFieldType(field, IntegerThing.class);
////		System.out.println("erased = " + GenericTypeReflector.erase(t));
//		WildcardType wc = (WildcardType) GenericTypeReflector
//			.getTypeParameter(t, RealType.class.getTypeParameters()[0]);
//		System.out.println("first RealType param = " + wc);
////		System.out.println(((ParameterizedType) t).getActualTypeArguments()[0].getClass().getName());
//
//		System.out.println();
//		System.out.println("== RealThing<?> ==");
//		Type type = GenericTypeReflector.addWildcardParameters(RealThing.class);
//		System.out.println(type.getTypeName());
//		if (type instanceof ParameterizedType) {
//			ParameterizedType pt = (ParameterizedType) type;
//			for (Type arg : pt.getActualTypeArguments()) {
//				// need to iterate all upper and lower bounds
//				((WildcardType) arg).getLowerBounds();
//				System.out.println("=> " + arg.getTypeName() + " [" + arg.getClass() + "]");
//			}
//		}
	}

	private static void dump(String fieldName, Class<?> fieldClass, Class<?> viewClass, Class<?> superClass) {
		System.out.println("Field " + fieldClass.getName() + "." + fieldName + ":");

		// This step is already done in ModuleItem.getGenericType()
		Type exactType = exactType(fieldName, fieldClass, viewClass);

		System.out.println("=> exact type (viewed through " + viewClass.getName() + ") = " + exactType.getTypeName());

		// Now we want to ask: for this generic type: what does it look like
		// with respect to one of its super types?
		// For example, if FloatImg extends ArrayImg<FloatType>, and you ask
		// for getExactSuperType(FloatImg, Img), you'll get Img<FloatType>.
		Type type = GenericTypeReflector.getExactSuperType(exactType, superClass);
		
		// If this returns null, then superClass is not a supertype of the type
		// in question, in which case we do not have a real match.

		// If this returns a Class, then supertype has no type parameter for superClass.
		// But (in our case at least?), this should not happen if superClass has type parameters.
		// Let's check for that scenario and throw an exception in that case.
		// i.e.: superClass.getTypeParameters().length == ((ParameterizedType) type).getActualTypeArguments().length

		

		// - need to recurse as appropriate
		// - 

		// Now that we have the exact super type, 
		System.out.println("Exact supertype of " + superClass.getName() + ": " + type.getTypeName());

		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			for (Type arg : pt.getActualTypeArguments()) {
				System.out.println("=> " + arg.getTypeName());
			}
		}
		System.out.println();
	}

	private static Type exactType(String fieldName, Class<?> fieldClass,
		Class<?> viewClass)
	{
		Field field = ClassUtils.getField(fieldClass, fieldName);
//		return GenericUtils.getFieldType(field, viewClass);
		final Type viewWildType = GenericTypeReflector.addWildcardParameters(
			viewClass);
		return GenericTypeReflector.getExactFieldType(field, viewWildType);
	}
}
