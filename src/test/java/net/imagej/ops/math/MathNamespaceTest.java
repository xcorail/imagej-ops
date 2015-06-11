/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2014 - 2015 Board of Regents of the University of
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

import net.imagej.ops.AbstractNamespaceTest;
import net.imagej.ops.MathOps.Abs;
import net.imagej.ops.MathOps.Add;
import net.imagej.ops.MathOps.AddNoise;
import net.imagej.ops.MathOps.And;
import net.imagej.ops.MathOps.Arccos;
import net.imagej.ops.MathOps.Arccosh;
import net.imagej.ops.MathOps.Arccot;
import net.imagej.ops.MathOps.Arccoth;
import net.imagej.ops.MathOps.Arccsc;
import net.imagej.ops.MathOps.Arccsch;
import net.imagej.ops.MathOps.Arcsec;
import net.imagej.ops.MathOps.Arcsech;
import net.imagej.ops.MathOps.Arcsin;
import net.imagej.ops.MathOps.Arcsinh;
import net.imagej.ops.MathOps.Arctan;
import net.imagej.ops.MathOps.Arctanh;
import net.imagej.ops.MathOps.Ceil;
import net.imagej.ops.MathOps.Complement;
import net.imagej.ops.MathOps.Copy;
import net.imagej.ops.MathOps.Cos;
import net.imagej.ops.MathOps.Cosh;
import net.imagej.ops.MathOps.Cot;
import net.imagej.ops.MathOps.Coth;
import net.imagej.ops.MathOps.Csc;
import net.imagej.ops.MathOps.Csch;
import net.imagej.ops.MathOps.CubeRoot;
import net.imagej.ops.MathOps.Divide;
import net.imagej.ops.MathOps.Exp;
import net.imagej.ops.MathOps.ExpMinusOne;

import org.junit.Test;

/**
 * Tests that the ops of the math namespace have corresponding type-safe Java
 * method signatures declared in the {@link MathNamespace} class.
 *
 * @author Curtis Rueden
 */
public class MathNamespaceTest extends AbstractNamespaceTest {

	/** Tests for {@link Abs} method convergence. */
	@Test
	public void testAbs() {
		assertComplete("math", MathNamespace.class, Abs.NAME);
	}

	/** Tests for {@link Add} method convergence. */
	@Test
	public void testAdd() {
		assertComplete("math", MathNamespace.class, Add.NAME);
	}

	/** Tests for {@link AddNoise} method convergence. */
	@Test
	public void testAddNoise() {
		assertComplete("math", MathNamespace.class, AddNoise.NAME);
	}

	/** Tests for {@link And} method convergence. */
	@Test
	public void testAnd() {
		assertComplete("math", MathNamespace.class, And.NAME);
	}

	/** Tests for {@link Arccos} method convergence. */
	@Test
	public void testArccos() {
		assertComplete("math", MathNamespace.class, Arccos.NAME);
	}

	/** Tests for {@link Arccosh} method convergence. */
	@Test
	public void testArccosh() {
		assertComplete("math", MathNamespace.class, Arccosh.NAME);
	}

	/** Tests for {@link Arccot} method convergence. */
	@Test
	public void testArccot() {
		assertComplete("math", MathNamespace.class, Arccot.NAME);
	}

	/** Tests for {@link Arccoth} method convergence. */
	@Test
	public void testArccoth() {
		assertComplete("math", MathNamespace.class, Arccoth.NAME);
	}

	/** Tests for {@link Arccsc} method convergence. */
	@Test
	public void testArccsc() {
		assertComplete("math", MathNamespace.class, Arccsc.NAME);
	}

	/** Tests for {@link Arccsch} method convergence. */
	@Test
	public void testArccsch() {
		assertComplete("math", MathNamespace.class, Arccsch.NAME);
	}

	/** Tests for {@link Arcsec} method convergence. */
	@Test
	public void testArcsec() {
		assertComplete("math", MathNamespace.class, Arcsec.NAME);
	}

	/** Tests for {@link Arcsech} method convergence. */
	@Test
	public void testArcsech() {
		assertComplete("math", MathNamespace.class, Arcsech.NAME);
	}

	/** Tests for {@link Arcsin} method convergence. */
	@Test
	public void testArcsin() {
		assertComplete("math", MathNamespace.class, Arcsin.NAME);
	}

	/** Tests for {@link Arcsinh} method convergence. */
	@Test
	public void testArcsinh() {
		assertComplete("math", MathNamespace.class, Arcsinh.NAME);
	}

	/** Tests for {@link Arctan} method convergence. */
	@Test
	public void testArctan() {
		assertComplete("math", MathNamespace.class, Arctan.NAME);
	}

	/** Tests for {@link Arctanh} method convergence. */
	@Test
	public void testArctanh() {
		assertComplete("math", MathNamespace.class, Arctanh.NAME);
	}

	/** Tests for {@link Ceil} method convergence. */
	@Test
	public void testCeil() {
		assertComplete("math", MathNamespace.class, Ceil.NAME);
	}

	/** Tests for {@link Complement} method convergence. */
	@Test
	public void testComplement() {
		assertComplete("math", MathNamespace.class, Complement.NAME);
	}

	/** Tests for {@link Copy} method convergence. */
	@Test
	public void testCopy() {
		assertComplete("math", MathNamespace.class, Copy.NAME);
	}

	/** Tests for {@link Cos} method convergence. */
	@Test
	public void testCos() {
		assertComplete("math", MathNamespace.class, Cos.NAME);
	}

	/** Tests for {@link Cosh} method convergence. */
	@Test
	public void testCosh() {
		assertComplete("math", MathNamespace.class, Cosh.NAME);
	}

	/** Tests for {@link Cot} method convergence. */
	@Test
	public void testCot() {
		assertComplete("math", MathNamespace.class, Cot.NAME);
	}

	/** Tests for {@link Coth} method convergence. */
	@Test
	public void testCoth() {
		assertComplete("math", MathNamespace.class, Coth.NAME);
	}

	/** Tests for {@link Csc} method convergence. */
	@Test
	public void testCsc() {
		assertComplete("math", MathNamespace.class, Csc.NAME);
	}

	/** Tests for {@link Csch} method convergence. */
	@Test
	public void testCsch() {
		assertComplete("math", MathNamespace.class, Csch.NAME);
	}

	/** Tests for {@link CubeRoot} method convergence. */
	@Test
	public void testCubeRoot() {
		assertComplete("math", MathNamespace.class, CubeRoot.NAME);
	}

	/** Tests for {@link Divide} method convergence. */
	@Test
	public void testDivide() {
		assertComplete("math", MathNamespace.class, Divide.NAME);
	}

	/** Tests for {@link Exp} method convergence. */
	@Test
	public void testExp() {
		assertComplete("math", MathNamespace.class, Exp.NAME);
	}

	/** Tests for {@link ExpMinusOne} method convergence. */
	@Test
	public void testExpMinusOne() {
		assertComplete("math", MathNamespace.class, ExpMinusOne.NAME);
	}
}
