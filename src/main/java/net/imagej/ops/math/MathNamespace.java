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

package net.imagej.ops.math;

import net.imagej.ops.AbstractNamespace;
import net.imagej.ops.Namespace;
import net.imagej.ops.OpMethod;
import net.imagej.ops.Ops;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.img.array.ArrayImg;
import net.imglib2.img.basictypeaccess.array.ArrayDataAccess;
import net.imglib2.img.basictypeaccess.array.ByteArray;
import net.imglib2.img.basictypeaccess.array.DoubleArray;
import net.imglib2.img.basictypeaccess.array.FloatArray;
import net.imglib2.img.basictypeaccess.array.IntArray;
import net.imglib2.img.basictypeaccess.array.LongArray;
import net.imglib2.img.basictypeaccess.array.ShortArray;
import net.imglib2.img.planar.PlanarImg;
import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.NumericType;
import net.imglib2.type.numeric.RealType;
import net.imglib2.type.numeric.integer.ByteType;
import net.imglib2.type.numeric.integer.GenericByteType;
import net.imglib2.type.numeric.integer.GenericIntType;
import net.imglib2.type.numeric.integer.GenericShortType;
import net.imglib2.type.numeric.integer.IntType;
import net.imglib2.type.numeric.integer.LongType;
import net.imglib2.type.numeric.real.DoubleType;
import net.imglib2.type.numeric.real.FloatType;

import org.scijava.plugin.Plugin;

/**
 * The math namespace contains arithmetic operations.
 *
 * @author Curtis Rueden
 */
@Plugin(type = Namespace.class)
public class MathNamespace extends AbstractNamespace {

	// -- Math namespace ops --

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleAbs.class)
	public double abs(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleAbs.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatAbs.class)
	public float abs(final float a) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatAbs.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerAbs.class)
	public int abs(final int a) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerAbs.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongAbs.class)
	public long abs(final long a) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongAbs.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Abs.class)
	public <I extends RealType<I>, O extends RealType<O>> O abs(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Abs.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Abs.class)
	public Object abs(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Abs.class, args);
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.MultiplyByte.class,
		net.imagej.ops.math.ConstantToArrayImage.MultiplyByte.class })
	public ArrayImg<ByteType, ByteArray> multiply(
		final ArrayImg<ByteType, ByteArray> image, final byte value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<ByteType, ByteArray> result =
			(ArrayImg<ByteType, ByteArray>) ops().run(Ops.Math.Multiply.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.MultiplyDouble.class,
		net.imagej.ops.math.ConstantToArrayImage.MultiplyDouble.class })
	public ArrayImg<DoubleType, DoubleArray> multiply(
		final ArrayImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<DoubleType, DoubleArray> result =
			(ArrayImg<DoubleType, DoubleArray>) ops().run(Ops.Math.Multiply.NAME,
				image, value);
		return result;
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.MultiplyFloat.class,
		net.imagej.ops.math.ConstantToArrayImage.MultiplyFloat.class })
	public ArrayImg<FloatType, FloatArray> multiply(
		final ArrayImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<FloatType, FloatArray> result =
			(ArrayImg<FloatType, FloatArray>) ops().run(Ops.Math.Multiply.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.MultiplyInt.class,
		net.imagej.ops.math.ConstantToArrayImage.MultiplyInt.class })
	public ArrayImg<IntType, IntArray> multiply(
		final ArrayImg<IntType, IntArray> image, final int value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<IntType, IntArray> result =
			(ArrayImg<IntType, IntArray>) ops().run(Ops.Math.Multiply.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.MultiplyLong.class,
		net.imagej.ops.math.ConstantToArrayImage.MultiplyLong.class })
	public ArrayImg<LongType, LongArray> multiply(
		final ArrayImg<LongType, LongArray> image, final long value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<LongType, LongArray> result =
			(ArrayImg<LongType, LongArray>) ops().run(Ops.Math.Multiply.NAME, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleAdd.class)
	public double add(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleAdd.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatAdd.class)
	public float add(final float a, final float b) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatAdd.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Add.class)
	public <T extends NumericType<T>> IterableInterval<T> add(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Add.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Add.class)
	public <T extends NumericType<T>> IterableInterval<T> add(
		final IterableInterval<T> in1, final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Add.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerAdd.class)
	public int add(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerAdd.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Add.class)
	public <T extends NumericType<T>> IterableInterval<T> add(
		final IterableInterval<T> in1, final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Add.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Add.class)
	public <T extends NumericType<T>> IterableInterval<T> add(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Add.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Add.class)
	public <T extends NumericType<T>> IterableInterval<T> add(
		final IterableInterval<T> in, final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Add.class, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Add.class)
	public <T extends NumericType<T>> IterableInterval<T> add(
		final IterableInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Add.class, out, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongAdd.class)
	public long add(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongAdd.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Add.class)
	public <I extends RealType<I>, O extends RealType<O>> O add(final O out,
		final I in, final double constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Add.class, out,
			in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealBinaryMath.Add.class)
	public <
		I1 extends RealType<I1>, I2 extends RealType<I2>, O extends RealType<O>> O
		add(final O out, final I1 in1, final I2 in2)
	{
		final Class<?> outClass = out.getClass();
		final Class<?> in1Class = in1.getClass();
		final Class<?> in2Class = in2.getClass();
		if (outClass.equals(in1Class) && outClass.equals(in2Class)) {
			@SuppressWarnings("unchecked")
			final O result = (O) ops().run(
				net.imagej.ops.math.NumericTypeBinaryMath.Add.class, out, in1, in2);
			return result;
		}
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealBinaryMath.Add.class,
			out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Add.class)
	public Object add(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Add.class, args);
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.AddByte.class,
			net.imagej.ops.math.ConstantToPlanarImage.AddUnsignedByte.class })
	public <B extends GenericByteType<B>> PlanarImg<B, ByteArray> add(final PlanarImg<B, ByteArray> image,
			final byte value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<B, ByteArray> result = (PlanarImg<B, ByteArray>) ops().run(Ops.Math.Add.NAME, image, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.AddDouble.class)
	public PlanarImg<DoubleType, DoubleArray> add(
		final PlanarImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<DoubleType, DoubleArray> result =
			(PlanarImg<DoubleType, DoubleArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.AddDouble.class, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.AddFloat.class)
	public PlanarImg<FloatType, FloatArray> add(
		final PlanarImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<FloatType, FloatArray> result =
			(PlanarImg<FloatType, FloatArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.AddFloat.class, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.AddInt.class,
			net.imagej.ops.math.ConstantToPlanarImage.AddUnsignedInt.class })
	public <I extends GenericIntType<I>> PlanarImg<I, IntArray> add(final PlanarImg<I, IntArray> image,
			final int value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<I, IntArray> result = (PlanarImg<I, IntArray>) ops().run(Ops.Math.Add.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.AddLong.class,
			net.imagej.ops.math.ConstantToPlanarImage.AddUnsignedLong.class })
	public <N extends NativeType<N>> PlanarImg<N, LongArray> add(final PlanarImg<N, LongArray> image,
			final long value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<N, LongArray> result = (PlanarImg<N, LongArray>) ops().run(Ops.Math.Add.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.AddShort.class,
			net.imagej.ops.math.ConstantToPlanarImage.AddUnsignedShort.class })
	public <S extends GenericShortType<S>> PlanarImg<S, ShortArray> add(final PlanarImg<S, ShortArray> arg,
			final short value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<S, ShortArray> result = (PlanarImg<S, ShortArray>) ops().run(Ops.Math.Add.NAME, arg, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputRAI.Add.class)
	public <T extends NumericType<T>> RandomAccessibleInterval<T> add(
		final RandomAccessibleInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final RandomAccessibleInterval<T> result =
			(RandomAccessibleInterval<T>) ops().run(
				net.imagej.ops.math.ConstantToIIOutputRAI.Add.class, out, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Add.class)
	public <T extends NumericType<T>> T add(final T in, final T b) {
		@SuppressWarnings("unchecked")
		final T result = (T) ops().run(
			net.imagej.ops.math.NumericTypeBinaryMath.Add.class, in, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Add.class)
	public <
		I1 extends NumericType<I1>, I2 extends NumericType<I2>, O extends NumericType<O>>
		O add(final O out, final I1 in1, final I2 in2)
	{
		final Class<?> outClass = out.getClass();
		final Class<?> in1Class = in1.getClass();
		final Class<?> in2Class = in2.getClass();
		if (outClass.equals(in1Class) && outClass.equals(in2Class)) {
			@SuppressWarnings("unchecked")
			final O result = (O) ops().run(
				net.imagej.ops.math.NumericTypeBinaryMath.Add.class, out, in1, in2);
			return result;
		}
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.Ops.Math.Add.class, out, in1,
			in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerAnd.class)
	public int and(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerAnd.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongAnd.class)
	public long and(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongAnd.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.AndConstant.class)
	public <I extends RealType<I>, O extends RealType<O>> O and(final O out,
		final I in, final long constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.AndConstant.class, out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealBinaryMath.And.class)
	public <
		I1 extends RealType<I1>, I2 extends RealType<I2>, O extends RealType<O>> O
		and(final O out, final I1 in1, final I2 in2)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealBinaryMath.And.class,
			out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.And.class)
	public Object and(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.And.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleArccos.class)
	public double arccos(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleArccos.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arccos.class)
	public <I extends RealType<I>, O extends RealType<O>> O arccos(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arccos.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arccos.class)
	public Object arccos(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arccos.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arccosh.class)
	public <I extends RealType<I>, O extends RealType<O>> O arccosh(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arccosh.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arccosh.class)
	public Object arccosh(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arccosh.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arccot.class)
	public <I extends RealType<I>, O extends RealType<O>> O arccot(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arccot.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arccot.class)
	public Object arccot(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arccot.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arccoth.class)
	public <I extends RealType<I>, O extends RealType<O>> O arccoth(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arccoth.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arccoth.class)
	public Object arccoth(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arccoth.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arccsc.class)
	public <I extends RealType<I>, O extends RealType<O>> O arccsc(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arccsc.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arccsc.class)
	public Object arccsc(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arccsc.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arccsch.class)
	public <I extends RealType<I>, O extends RealType<O>> O arccsch(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arccsch.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arccsch.class)
	public Object arccsch(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arccsch.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arcsec.class)
	public <I extends RealType<I>, O extends RealType<O>> O arcsec(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arcsec.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arcsec.class)
	public Object arcsec(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arcsec.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arcsech.class)
	public <I extends RealType<I>, O extends RealType<O>> O arcsech(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arcsech.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arcsech.class)
	public Object arcsech(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arcsech.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleArcsin.class)
	public double arcsin(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleArcsin.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arcsin.class)
	public <I extends RealType<I>, O extends RealType<O>> O arcsin(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arcsin.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arcsin.class)
	public Object arcsin(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arcsin.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arcsinh.class)
	public <I extends RealType<I>, O extends RealType<O>> O arcsinh(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arcsinh.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arcsinh.class)
	public Object arcsinh(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arcsinh.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleArctan.class)
	public double arctan(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleArctan.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arctan.class)
	public <I extends RealType<I>, O extends RealType<O>> O arctan(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arctan.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arctan.class)
	public Object arctan(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arctan.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Arctanh.class)
	public <I extends RealType<I>, O extends RealType<O>> O arctanh(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Arctanh.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Arctanh.class)
	public Object arctanh(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Arctanh.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleCeil.class)
	public double ceil(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleCeil.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Ceil.class)
	public <I extends RealType<I>, O extends RealType<O>> O ceil(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Ceil.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Ceil.class)
	public Object ceil(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Ceil.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerComplement.class)
	public int complement(final int a) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerComplement.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongComplement.class)
	public long complement(final long a) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongComplement.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Complement.class)
	public Object complement(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Complement.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleCos.class)
	public double cos(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleCos.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Cos.class)
	public <I extends RealType<I>, O extends RealType<O>> O cos(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Cos.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Cos.class)
	public Object cos(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Cos.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleCosh.class)
	public double cosh(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleCosh.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Cosh.class)
	public <I extends RealType<I>, O extends RealType<O>> O cosh(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Cosh.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Cosh.class)
	public Object cosh(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Cosh.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Cot.class)
	public <I extends RealType<I>, O extends RealType<O>> O cot(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Cot.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Cot.class)
	public Object cot(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Cot.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Coth.class)
	public <I extends RealType<I>, O extends RealType<O>> O coth(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Coth.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Coth.class)
	public Object coth(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Coth.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Csc.class)
	public <I extends RealType<I>, O extends RealType<O>> O csc(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Csc.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Csc.class)
	public Object csc(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Csc.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Csch.class)
	public <I extends RealType<I>, O extends RealType<O>> O csch(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Csch.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Csch.class)
	public Object csch(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Csch.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleCubeRoot.class)
	public double cubeRoot(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleCubeRoot.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.CubeRoot.class)
	public <I extends RealType<I>, O extends RealType<O>> O cubeRoot(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.CubeRoot.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.CubeRoot.class)
	public Object cubeRoot(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.CubeRoot.class, args);
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.DivideByte.class,
		net.imagej.ops.math.ConstantToArrayImage.DivideByte.class })
	public ArrayImg<ByteType, ByteArray> divide(
		final ArrayImg<ByteType, ByteArray> image, final byte value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<ByteType, ByteArray> result =
			(ArrayImg<ByteType, ByteArray>) ops().run(Ops.Math.Divide.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.DivideDouble.class,
		net.imagej.ops.math.ConstantToArrayImage.DivideDouble.class })
	public ArrayImg<DoubleType, DoubleArray> divide(
		final ArrayImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<DoubleType, DoubleArray> result =
			(ArrayImg<DoubleType, DoubleArray>) ops().run(Ops.Math.Divide.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.DivideFloat.class,
		net.imagej.ops.math.ConstantToArrayImage.DivideFloat.class })
	public ArrayImg<FloatType, FloatArray> divide(
		final ArrayImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<FloatType, FloatArray> result =
			(ArrayImg<FloatType, FloatArray>) ops().run(Ops.Math.Divide.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.DivideInt.class,
		net.imagej.ops.math.ConstantToArrayImage.DivideInt.class })
	public ArrayImg<IntType, IntArray> divide(
		final ArrayImg<IntType, IntArray> image, final int value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<IntType, IntArray> result =
			(ArrayImg<IntType, IntArray>) ops().run(Ops.Math.Divide.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.DivideLong.class,
		net.imagej.ops.math.ConstantToArrayImage.DivideLong.class })
	public ArrayImg<LongType, LongArray> divide(
		final ArrayImg<LongType, LongArray> image, final long value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<LongType, LongArray> result =
			(ArrayImg<LongType, LongArray>) ops().run(Ops.Math.Divide.NAME, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleDivide.class)
	public double divide(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleDivide.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatDivide.class)
	public float divide(final float a, final float b) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatDivide.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Divide.class)
	public <T extends NumericType<T>> IterableInterval<T> divide(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Divide.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Divide.class)
	public <T extends NumericType<T>> IterableInterval<T> divide(
		final IterableInterval<T> in1, final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Divide.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerDivide.class)
	public int divide(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerDivide.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Divide.class)
	public <T extends NumericType<T>> IterableInterval<T> divide(
		final IterableInterval<T> in1, final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Divide.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Divide.class)
	public <T extends NumericType<T>> IterableInterval<T> divide(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Divide.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Divide.class)
	public <T extends NumericType<T>> IterableInterval<T> divide(
		final IterableInterval<T> in, final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Divide.class, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Divide.class)
	public <T extends NumericType<T>> IterableInterval<T> divide(
		final IterableInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Divide.class, out, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongDivide.class)
	public long divide(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongDivide.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Divide.class)
	public <I extends RealType<I>, O extends RealType<O>> O divide(final O out,
		final I in, final double constant, final double dbzVal)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Divide.class,
			out, in, constant, dbzVal);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealBinaryMath.Divide.class)
	public <
		I1 extends RealType<I1>, I2 extends RealType<I2>, O extends RealType<O>> O
		divide(final O out, final I1 in1, final I2 in2, final double dbzVal)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealBinaryMath.Divide.class, out, in1, in2, dbzVal);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Divide.class)
	public Object divide(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Divide.class, args);
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.DivideByte.class,
			net.imagej.ops.math.ConstantToPlanarImage.DivideUnsignedByte.class })
	public <B extends GenericByteType<B>> PlanarImg<B, ByteArray> divide(final PlanarImg<B, ByteArray> image,
			final byte value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<B, ByteArray> result = (PlanarImg<B, ByteArray>) ops().run(Ops.Math.Divide.NAME, image, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.DivideDouble.class)
	public PlanarImg<DoubleType, DoubleArray> divide(
		final PlanarImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<DoubleType, DoubleArray> result =
			(PlanarImg<DoubleType, DoubleArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.DivideDouble.class, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.DivideFloat.class)
	public PlanarImg<FloatType, FloatArray> divide(
		final PlanarImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<FloatType, FloatArray> result =
			(PlanarImg<FloatType, FloatArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.DivideFloat.class, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.DivideInt.class,
			net.imagej.ops.math.ConstantToPlanarImage.DivideUnsignedInt.class })
	public <I extends GenericIntType<I>> PlanarImg<I, IntArray> divide(final PlanarImg<I, IntArray> image,
			final int value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<I, IntArray> result = (PlanarImg<I, IntArray>) ops().run(Ops.Math.Divide.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.DivideLong.class,
			net.imagej.ops.math.ConstantToPlanarImage.DivideUnsignedLong.class })
	public <N extends NativeType<N>> PlanarImg<N, LongArray> divide(final PlanarImg<N, LongArray> image,
			final long value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<N, LongArray> result = (PlanarImg<N, LongArray>) ops().run(Ops.Math.Divide.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.DivideShort.class,
			net.imagej.ops.math.ConstantToPlanarImage.DivideUnsignedShort.class })
	public <S extends GenericShortType<S>> PlanarImg<S, ShortArray> divide(final PlanarImg<S, ShortArray> arg,
			final short value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<S, ShortArray> result = (PlanarImg<S, ShortArray>) ops().run(Ops.Math.Divide.NAME, arg, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputRAI.Divide.class)
	public <T extends NumericType<T>> RandomAccessibleInterval<T> divide(
		final RandomAccessibleInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final RandomAccessibleInterval<T> result =
			(RandomAccessibleInterval<T>) ops().run(
				net.imagej.ops.math.ConstantToIIOutputRAI.Divide.class, out, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Divide.class)
	public <T extends NumericType<T>> T divide(final T in, final T b) {
		@SuppressWarnings("unchecked")
		final T result = (T) ops().run(
			net.imagej.ops.math.NumericTypeBinaryMath.Divide.class, in, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Divide.class)
	public <T extends NumericType<T>> T divide(final T out, final T in,
		final T b)
	{
		@SuppressWarnings("unchecked")
		final T result = (T) ops().run(
			net.imagej.ops.math.NumericTypeBinaryMath.Divide.class, out, in, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleExp.class)
	public double exp(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleExp.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Exp.class)
	public <I extends RealType<I>, O extends RealType<O>> O exp(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Exp.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Exp.class)
	public Object exp(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Exp.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.ExpMinusOne.class)
	public <I extends RealType<I>, O extends RealType<O>> O expMinusOne(
		final O out, final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.ExpMinusOne.class, out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.ExpMinusOne.class)
	public Object expMinusOne(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.ExpMinusOne.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleFloor.class)
	public double floor(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleFloor.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Floor.class)
	public <I extends RealType<I>, O extends RealType<O>> O floor(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Floor.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Floor.class)
	public Object floor(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Floor.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.GammaConstant.class)
	public <I extends RealType<I>, O extends RealType<O>> O gamma(final O out,
		final I in, final double constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.GammaConstant.class, out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Gamma.class)
	public Object gamma(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Gamma.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Invert.class)
	public <I extends RealType<I>, O extends RealType<O>> O invert(final O out,
		final I in, final double specifiedMin, final double specifiedMax)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Invert.class,
			out, in, specifiedMin, specifiedMax);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Invert.class)
	public Object invert(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Invert.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerLeftShift.class)
	public int leftShift(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerLeftShift.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongLeftShift.class)
	public long leftShift(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongLeftShift.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.LeftShift.class)
	public Object leftShift(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.LeftShift.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleLog.class)
	public double log(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleLog.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Log.class)
	public <I extends RealType<I>, O extends RealType<O>> O log(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Log.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Log.class)
	public Object log(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Log.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleLog10.class)
	public double log10(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleLog10.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Log10.class)
	public <I extends RealType<I>, O extends RealType<O>> O log10(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Log10.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Log10.class)
	public Object log10(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Log10.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Log2.class)
	public <I extends RealType<I>, O extends RealType<O>> O log2(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Log2.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Log2.class)
	public Object log2(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Log2.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleLogOnePlusX.class)
	public double logOnePlusX(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleLogOnePlusX.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.LogOnePlusX.class)
	public <I extends RealType<I>, O extends RealType<O>> O logOnePlusX(
		final O out, final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.LogOnePlusX.class, out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.LogOnePlusX.class)
	public Object logOnePlusX(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.LogOnePlusX.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleMax.class)
	public double max(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleMax.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatMax.class)
	public float max(final float a, final float b) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatMax.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerMax.class)
	public int max(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerMax.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongMax.class)
	public long max(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongMax.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.MaxConstant.class)
	public <I extends RealType<I>, O extends RealType<O>> O max(final O out,
		final I in, final double constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.MaxConstant.class, out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Max.class)
	public Object max(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Max.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleMin.class)
	public double min(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleMin.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatMin.class)
	public float min(final float a, final float b) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatMin.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerMin.class)
	public int min(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerMin.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongMin.class)
	public long min(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongMin.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.MinConstant.class)
	public <I extends RealType<I>, O extends RealType<O>> O min(final O out,
		final I in, final double constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.MinConstant.class, out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Min.class)
	public Object min(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Min.class, args);
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.AddByte.class,
		net.imagej.ops.math.ConstantToArrayImage.AddByte.class })
	public ArrayImg<ByteType, ByteArray> add(
		final ArrayImg<ByteType, ByteArray> image, final byte value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<ByteType, ByteArray> result =
			(ArrayImg<ByteType, ByteArray>) ops().run(Ops.Math.Add.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.AddDouble.class,
		net.imagej.ops.math.ConstantToArrayImage.AddDouble.class })
	public ArrayImg<DoubleType, DoubleArray> add(
		final ArrayImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<DoubleType, DoubleArray> result =
			(ArrayImg<DoubleType, DoubleArray>) ops().run(Ops.Math.Add.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.AddFloat.class,
		net.imagej.ops.math.ConstantToArrayImage.AddFloat.class })
	public ArrayImg<FloatType, FloatArray> add(
		final ArrayImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<FloatType, FloatArray> result =
			(ArrayImg<FloatType, FloatArray>) ops().run(Ops.Math.Add.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.AddInt.class,
		net.imagej.ops.math.ConstantToArrayImage.AddInt.class })
	public ArrayImg<IntType, IntArray> add(
		final ArrayImg<IntType, IntArray> image, final int value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<IntType, IntArray> result =
			(ArrayImg<IntType, IntArray>) ops().run(Ops.Math.Add.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.AddLong.class,
		net.imagej.ops.math.ConstantToArrayImage.AddLong.class })
	public ArrayImg<LongType, LongArray> add(
		final ArrayImg<LongType, LongArray> image, final long value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<LongType, LongArray> result =
			(ArrayImg<LongType, LongArray>) ops().run(Ops.Math.Add.NAME, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleMultiply.class)
	public double multiply(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleMultiply.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatMultiply.class)
	public float multiply(final float a, final float b) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatMultiply.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Multiply.class)
	public <T extends NumericType<T>> IterableInterval<T> multiply(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Multiply.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Multiply.class)
	public <T extends NumericType<T>> IterableInterval<T> multiply(
		final IterableInterval<T> in1, final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Multiply.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerMultiply.class)
	public int multiply(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerMultiply.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Multiply.class)
	public <T extends NumericType<T>> IterableInterval<T> multiply(
		final IterableInterval<T> in1, final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Multiply.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Multiply.class)
	public <T extends NumericType<T>> IterableInterval<T> multiply(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Multiply.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Multiply.class)
	public <T extends NumericType<T>> IterableInterval<T> multiply(
		final IterableInterval<T> in, final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Multiply.class, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Multiply.class)
	public <T extends NumericType<T>> IterableInterval<T> multiply(
		final IterableInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Multiply.class, out, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongMultiply.class)
	public long multiply(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongMultiply.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Multiply.class)
	public <I extends RealType<I>, O extends RealType<O>> O multiply(final O out,
		final I in, final double constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Multiply.class,
			out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealBinaryMath.Multiply.class)
	public <
		I1 extends RealType<I1>, I2 extends RealType<I2>, O extends RealType<O>> O
		multiply(final O out, final I1 in1, final I2 in2)
	{
		final Class<?> outClass = out.getClass();
		final Class<?> in1Class = in1.getClass();
		final Class<?> in2Class = in2.getClass();
		if (outClass.equals(in1Class) && outClass.equals(in2Class)) {
			@SuppressWarnings("unchecked")
			final O result = (O) ops().run(
				net.imagej.ops.math.NumericTypeBinaryMath.Multiply.class, out, in1,
				in2);
			return result;
		}
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealBinaryMath.Multiply.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Multiply.class)
	public Object multiply(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Multiply.class, args);
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.MultiplyByte.class,
			net.imagej.ops.math.ConstantToPlanarImage.MultiplyUnsignedByte.class })
	public <B extends GenericByteType<B>> PlanarImg<B, ByteArray> multiply(final PlanarImg<B, ByteArray> image,
			final byte value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<B, ByteArray> result = (PlanarImg<B, ByteArray>) ops().run(Ops.Math.Divide.NAME, image, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.MultiplyDouble.class)
	public PlanarImg<DoubleType, DoubleArray> multiply(
		final PlanarImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<DoubleType, DoubleArray> result =
			(PlanarImg<DoubleType, DoubleArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.MultiplyDouble.class, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.MultiplyFloat.class)
	public PlanarImg<FloatType, FloatArray> multiply(
		final PlanarImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<FloatType, FloatArray> result =
			(PlanarImg<FloatType, FloatArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.MultiplyFloat.class, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.MultiplyInt.class,
			net.imagej.ops.math.ConstantToPlanarImage.MultiplyUnsignedInt.class })
	public <I extends GenericIntType<I>> PlanarImg<I, IntArray> multiply(final PlanarImg<I, IntArray> image,
			final int value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<I, IntArray> result = (PlanarImg<I, IntArray>) ops().run(Ops.Math.Multiply.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.MultiplyLong.class,
			net.imagej.ops.math.ConstantToPlanarImage.MultiplyUnsignedLong.class })
	public <N extends NativeType<N>> PlanarImg<N, LongArray> multiply(final PlanarImg<N, LongArray> image,
			final long value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<N, LongArray> result = (PlanarImg<N, LongArray>) ops().run(Ops.Math.Multiply.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.MultiplyShort.class,
			net.imagej.ops.math.ConstantToPlanarImage.MultiplyUnsignedShort.class })
	public <S extends GenericShortType<S>> PlanarImg<S, ShortArray> multiply(final PlanarImg<S, ShortArray> arg,
			final short value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<S, ShortArray> result = (PlanarImg<S, ShortArray>) ops().run(Ops.Math.Multiply.NAME, arg, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputRAI.Multiply.class)
	public <T extends NumericType<T>> RandomAccessibleInterval<T> multiply(
		final RandomAccessibleInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final RandomAccessibleInterval<T> result =
			(RandomAccessibleInterval<T>) ops().run(
				net.imagej.ops.math.ConstantToIIOutputRAI.Multiply.class, out, in,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Multiply.class)
	public <T extends NumericType<T>> T multiply(final T in, final T b) {
		@SuppressWarnings("unchecked")
		final T result = (T) ops().run(
			net.imagej.ops.math.NumericTypeBinaryMath.Multiply.class, in, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Multiply.class)
	public <
		I1 extends NumericType<I1>, I2 extends NumericType<I2>, O extends NumericType<O>>
		O multiply(final O out, final I1 in1, final I2 in2)
	{
		final Class<?> outClass = out.getClass();
		final Class<?> in1Class = in1.getClass();
		final Class<?> in2Class = in2.getClass();
		if (outClass.equals(in1Class) && outClass.equals(in2Class)) {
			@SuppressWarnings("unchecked")
			final O result = (O) ops().run(
				net.imagej.ops.math.NumericTypeBinaryMath.Multiply.class, out, in1,
				in2);
			return result;
		}
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.Ops.Math.Multiply.class, out,
			in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.NearestInt.class)
	public <I extends RealType<I>, O extends RealType<O>> O nearestInt(
		final O out, final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.NearestInt.class, out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.NearestInt.class)
	public Object nearestInt(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.NearestInt.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleNegate.class)
	public double negate(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleNegate.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatNegate.class)
	public float negate(final float a) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatNegate.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerNegate.class)
	public int negate(final int a) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerNegate.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongNegate.class)
	public long negate(final long a) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongNegate.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Negate.class)
	public <I extends RealType<I>, O extends RealType<O>> O negate(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Negate.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Negate.class)
	public Object negate(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Negate.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerOr.class)
	public int or(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerOr.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongOr.class)
	public long or(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongOr.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.OrConstant.class)
	public <I extends RealType<I>, O extends RealType<O>> O or(final O out,
		final I in, final long constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.OrConstant.class, out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealBinaryMath.Or.class)
	public <
		I1 extends RealType<I1>, I2 extends RealType<I2>, O extends RealType<O>> O
		or(final O out, final I1 in1, final I2 in2)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealBinaryMath.Or.class,
			out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Or.class)
	public Object or(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Or.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoublePower.class)
	public double power(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoublePower.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.PowerConstant.class)
	public <I extends RealType<I>, O extends RealType<O>> O power(final O out,
		final I in, final double constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.PowerConstant.class, out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Power.class)
	public Object power(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Power.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.RandomGaussian.class)
	public <I extends RealType<I>, O extends RealType<O>> O randomGaussian(
		final O out, final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.RandomGaussian.class, out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.RandomGaussian.class)
	public <I extends RealType<I>, O extends RealType<O>> O randomGaussian(
		final O out, final I in, final long seed)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.RandomGaussian.class, out, in, seed);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.RandomGaussian.class)
	public Object randomGaussian(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.RandomGaussian.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.RandomUniform.class)
	public <I extends RealType<I>, O extends RealType<O>> O randomUniform(
		final O out, final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.RandomUniform.class, out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.RandomUniform.class)
	public <I extends RealType<I>, O extends RealType<O>> O randomUniform(
		final O out, final I in, final long seed)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.RandomUniform.class, out, in, seed);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.RandomUniform.class)
	public Object randomUniform(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.RandomUniform.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Reciprocal.class)
	public <I extends RealType<I>, O extends RealType<O>> O reciprocal(
		final O out, final I in, final double dbzVal)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.Reciprocal.class, out, in, dbzVal);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Reciprocal.class)
	public Object reciprocal(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Reciprocal.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleRemainder.class)
	public double remainder(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleRemainder.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatRemainder.class)
	public float remainder(final float a, final float b) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatRemainder.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerRemainder.class)
	public int remainder(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerRemainder.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongRemainder.class)
	public long remainder(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongRemainder.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Remainder.class)
	public Object remainder(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Remainder.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerRightShift.class)
	public int rightShift(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerRightShift.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongRightShift.class)
	public long rightShift(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongRightShift.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.RightShift.class)
	public Object rightShift(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.RightShift.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleRound.class)
	public double round(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleRound.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatRound.class)
	public float round(final float a) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatRound.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Round.class)
	public <I extends RealType<I>, O extends RealType<O>> O round(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Round.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Round.class)
	public Object round(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Round.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Sec.class)
	public <I extends RealType<I>, O extends RealType<O>> O sec(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Sec.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Sec.class)
	public Object sec(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Sec.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Sech.class)
	public <I extends RealType<I>, O extends RealType<O>> O sech(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Sech.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Sech.class)
	public Object sech(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Sech.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleSignum.class)
	public double signum(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleSignum.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatSignum.class)
	public float signum(final float a) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatSignum.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Signum.class)
	public <I extends RealType<I>, O extends RealType<O>> O signum(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Signum.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Signum.class)
	public Object signum(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Signum.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleSin.class)
	public double sin(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleSin.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Sin.class)
	public <I extends RealType<I>, O extends RealType<O>> O sin(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Sin.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Sin.class)
	public Object sin(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Sin.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Sinc.class)
	public <I extends RealType<I>, O extends RealType<O>> O sinc(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Sinc.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Sinc.class)
	public Object sinc(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Sinc.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.SincPi.class)
	public <I extends RealType<I>, O extends RealType<O>> O sincPi(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.SincPi.class,
			out, in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.SincPi.class)
	public Object sincPi(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.SincPi.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleSinh.class)
	public double sinh(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleSinh.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Sinh.class)
	public <I extends RealType<I>, O extends RealType<O>> O sinh(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Sinh.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Sinh.class)
	public Object sinh(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Sinh.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Sqr.class)
	public <I extends RealType<I>, O extends RealType<O>> O sqr(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Sqr.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Sqr.class)
	public Object sqr(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Sqr.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleSqrt.class)
	public double sqrt(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleSqrt.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Sqrt.class)
	public <I extends RealType<I>, O extends RealType<O>> O sqrt(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Sqrt.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Sqrt.class)
	public Object sqrt(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Sqrt.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Step.class)
	public <I extends RealType<I>, O extends RealType<O>> O step(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Step.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Step.class)
	public Object step(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Step.class, args);
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.SubtractByte.class,
		net.imagej.ops.math.ConstantToArrayImage.SubtractByte.class })
	public ArrayImg<ByteType, ByteArray> subtract(
		final ArrayImg<ByteType, ByteArray> image, final byte value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<ByteType, ByteArray> result =
			(ArrayImg<ByteType, ByteArray>) ops().run(Ops.Math.Subtract.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.SubtractDouble.class,
		net.imagej.ops.math.ConstantToArrayImage.SubtractDouble.class })
	public ArrayImg<DoubleType, DoubleArray> subtract(
		final ArrayImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<DoubleType, DoubleArray> result =
			(ArrayImg<DoubleType, DoubleArray>) ops().run(Ops.Math.Subtract.NAME,
				image, value);
		return result;
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.SubtractFloat.class,
		net.imagej.ops.math.ConstantToArrayImage.SubtractFloat.class })
	public ArrayImg<FloatType, FloatArray> subtract(
		final ArrayImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<FloatType, FloatArray> result =
			(ArrayImg<FloatType, FloatArray>) ops().run(Ops.Math.Subtract.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToArrayImageP.SubtractInt.class,
		net.imagej.ops.math.ConstantToArrayImage.SubtractInt.class })
	public ArrayImg<IntType, IntArray> subtract(
		final ArrayImg<IntType, IntArray> image, final int value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<IntType, IntArray> result =
			(ArrayImg<IntType, IntArray>) ops().run(Ops.Math.Subtract.NAME, image,
				value);
		return result;
	}

	@OpMethod(ops = {
		net.imagej.ops.math.ConstantToArrayImageP.SubtractLong.class,
		net.imagej.ops.math.ConstantToArrayImage.SubtractLong.class })
	public ArrayImg<LongType, LongArray> subtract(
		final ArrayImg<LongType, LongArray> image, final long value)
	{
		@SuppressWarnings("unchecked")
		final ArrayImg<LongType, LongArray> result =
			(ArrayImg<LongType, LongArray>) ops().run(Ops.Math.Subtract.NAME, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleSubtract.class)
	public double subtract(final double a, final double b) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleSubtract.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.FloatSubtract.class)
	public float subtract(final float a, final float b) {
		final float result = (Float) ops().run(
			net.imagej.ops.math.PrimitiveMath.FloatSubtract.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Subtract.class)
	public <T extends NumericType<T>> IterableInterval<T> subtract(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Subtract.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToIIOutputII.Subtract.class)
	public <T extends NumericType<T>> IterableInterval<T> subtract(
		final IterableInterval<T> in1, final IterableInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToIIOutputII.Subtract.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerSubtract.class)
	public int subtract(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerSubtract.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Subtract.class)
	public <T extends NumericType<T>> IterableInterval<T> subtract(
		final IterableInterval<T> in1, final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Subtract.class, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.IIToRAIOutputII.Subtract.class)
	public <T extends NumericType<T>> IterableInterval<T> subtract(
		final IterableInterval<T> out, final IterableInterval<T> in1,
		final RandomAccessibleInterval<T> in2)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.IIToRAIOutputII.Subtract.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Subtract.class)
	public <T extends NumericType<T>> IterableInterval<T> subtract(
		final IterableInterval<T> in, final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Subtract.class, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputII.Subtract.class)
	public <T extends NumericType<T>> IterableInterval<T> subtract(
		final IterableInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final IterableInterval<T> result = (IterableInterval<T>) ops().run(
			net.imagej.ops.math.ConstantToIIOutputII.Subtract.class, out, in, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongSubtract.class)
	public long subtract(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongSubtract.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Subtract.class)
	public <I extends RealType<I>, O extends RealType<O>> O subtract(final O out,
		final I in, final double constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Subtract.class,
			out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealBinaryMath.Subtract.class)
	public <
		I1 extends RealType<I1>, I2 extends RealType<I2>, O extends RealType<O>> O
		subtract(final O out, final I1 in1, final I2 in2)
	{
		final Class<?> outClass = out.getClass();
		final Class<?> in1Class = in1.getClass();
		final Class<?> in2Class = in2.getClass();
		if (outClass.equals(in1Class) && outClass.equals(in2Class)) {
			@SuppressWarnings("unchecked")
			final O result = (O) ops().run(
				net.imagej.ops.math.NumericTypeBinaryMath.Subtract.class, out, in1,
				in2);
			return result;
		}
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealBinaryMath.Subtract.class, out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Subtract.class)
	public Object subtract(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Subtract.class, args);
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.SubtractByte.class,
			net.imagej.ops.math.ConstantToPlanarImage.SubtractUnsignedByte.class })
	public <B extends GenericByteType<B>> PlanarImg<B, ByteArray> subtract(final PlanarImg<B, ByteArray> image,
			final byte value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<B, ByteArray> result = (PlanarImg<B, ByteArray>) ops()
				.run(Ops.Math.Subtract.NAME, image, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.SubtractDouble.class)
	public PlanarImg<DoubleType, DoubleArray> subtract(
		final PlanarImg<DoubleType, DoubleArray> image, final double value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<DoubleType, DoubleArray> result =
			(PlanarImg<DoubleType, DoubleArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.SubtractDouble.class, image,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToPlanarImage.SubtractFloat.class)
	public PlanarImg<FloatType, FloatArray> subtract(
		final PlanarImg<FloatType, FloatArray> image, final float value)
	{
		@SuppressWarnings("unchecked")
		final PlanarImg<FloatType, FloatArray> result =
			(PlanarImg<FloatType, FloatArray>) ops().run(
				net.imagej.ops.math.ConstantToPlanarImage.SubtractFloat.class, image,
				value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.SubtractInt.class,
			net.imagej.ops.math.ConstantToPlanarImage.SubtractUnsignedInt.class })
	public <I extends GenericIntType<I>> PlanarImg<I, IntArray> subtract(final PlanarImg<I, IntArray> image,
			final int value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<I, IntArray> result = (PlanarImg<I, IntArray>) ops()
				.run(Ops.Math.Subtract.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.SubtractLong.class,
			net.imagej.ops.math.ConstantToPlanarImage.SubtractUnsignedLong.class })
	public <N extends NativeType<N>, A extends ArrayDataAccess<A>> PlanarImg<N, A> subtract(final PlanarImg<N, A> image,
			final long value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<N, A> result = (PlanarImg<N, A>) ops().run(Ops.Math.Subtract.NAME, image, value);
		return result;
	}

	@OpMethod(ops = { net.imagej.ops.math.ConstantToPlanarImage.SubtractShort.class,
			net.imagej.ops.math.ConstantToPlanarImage.SubtractUnsignedShort.class })
	public <S extends GenericShortType<S>> PlanarImg<S, ShortArray> subtract(final PlanarImg<S, ShortArray> image,
			final short value) {
		@SuppressWarnings("unchecked")
		final PlanarImg<S, ShortArray> result = (PlanarImg<S, ShortArray>) ops()
				.run(Ops.Math.Subtract.NAME, image, value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.ConstantToIIOutputRAI.Subtract.class)
	public <T extends NumericType<T>> RandomAccessibleInterval<T> subtract(
		final RandomAccessibleInterval<T> out, final IterableInterval<T> in,
		final T value)
	{
		@SuppressWarnings("unchecked")
		final RandomAccessibleInterval<T> result =
			(RandomAccessibleInterval<T>) ops().run(
				net.imagej.ops.math.ConstantToIIOutputRAI.Subtract.class, out, in,
				value);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Subtract.class)
	public <T extends NumericType<T>> T subtract(final T in, final T b) {
		@SuppressWarnings("unchecked")
		final T result = (T) ops().run(
			net.imagej.ops.math.NumericTypeBinaryMath.Subtract.class, in, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeBinaryMath.Subtract.class)
	public <
		I1 extends NumericType<I1>, I2 extends NumericType<I2>, O extends NumericType<O>>
		O subtract(final O out, final I1 in1, final I2 in2)
	{
		final Class<?> outClass = out.getClass();
		final Class<?> in1Class = in1.getClass();
		final Class<?> in2Class = in2.getClass();
		if (outClass.equals(in1Class) && outClass.equals(in2Class)) {
			@SuppressWarnings("unchecked")
			final O result = (O) ops().run(
				net.imagej.ops.math.NumericTypeBinaryMath.Subtract.class, out, in1,
				in2);
			return result;
		}
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.Ops.Math.Subtract.class, out,
			in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleTan.class)
	public double tan(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleTan.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Tan.class)
	public <I extends RealType<I>, O extends RealType<O>> O tan(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Tan.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Tan.class)
	public Object tan(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Tan.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.DoubleTanh.class)
	public double tanh(final double a) {
		final double result = (Double) ops().run(
			net.imagej.ops.math.PrimitiveMath.DoubleTanh.class, a);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Tanh.class)
	public <I extends RealType<I>, O extends RealType<O>> O tanh(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Tanh.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Tanh.class)
	public Object tanh(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Tanh.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.Ulp.class)
	public <I extends RealType<I>, O extends RealType<O>> O ulp(final O out,
		final I in)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealMath.Ulp.class, out,
			in);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Ulp.class)
	public Object ulp(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Ulp.class, args);
	}

	@OpMethod(
		op = net.imagej.ops.math.PrimitiveMath.IntegerUnsignedRightShift.class)
	public int unsignedRightShift(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerUnsignedRightShift.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongUnsignedRightShift.class)
	public long unsignedRightShift(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongUnsignedRightShift.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.UnsignedRightShift.class)
	public Object unsignedRightShift(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.UnsignedRightShift.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.IntegerXor.class)
	public int xor(final int a, final int b) {
		final int result = (Integer) ops().run(
			net.imagej.ops.math.PrimitiveMath.IntegerXor.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.PrimitiveMath.LongXor.class)
	public long xor(final long a, final long b) {
		final long result = (Long) ops().run(
			net.imagej.ops.math.PrimitiveMath.LongXor.class, a, b);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealMath.XorConstant.class)
	public <I extends RealType<I>, O extends RealType<O>> O xor(final O out,
		final I in, final long constant)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(
			net.imagej.ops.math.RealMath.XorConstant.class, out, in, constant);
		return result;
	}

	@OpMethod(op = net.imagej.ops.math.RealBinaryMath.Xor.class)
	public <
		I1 extends RealType<I1>, I2 extends RealType<I2>, O extends RealType<O>> O
		xor(final O out, final I1 in1, final I2 in2)
	{
		@SuppressWarnings("unchecked")
		final O result = (O) ops().run(net.imagej.ops.math.RealBinaryMath.Xor.class,
			out, in1, in2);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Xor.class)
	public Object xor(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Xor.class, args);
	}

	@OpMethod(op = net.imagej.ops.math.NumericTypeNullaryMath.Zero.class)
	public <T extends NumericType<T>> T zero(final T out) {
		@SuppressWarnings("unchecked")
		final T result = (T) ops().run(
			net.imagej.ops.math.NumericTypeNullaryMath.Zero.class, out);
		return result;
	}

	@OpMethod(op = net.imagej.ops.Ops.Math.Zero.class)
	public Object zero(final Object... args) {
		return ops().run(net.imagej.ops.Ops.Math.Zero.class, args);
	}

	// -- Named methods --

	@Override
	public String getName() {
		return "math";
	}

}
