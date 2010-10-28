/*
 * Copyright 2002-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.ip.util;

import static org.junit.Assert.assertEquals;
import static org.springframework.integration.ip.util.RegexUtils.escapeRegExSpecials;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.integration.MessageHeaders;

/**
 * @author Gary Russell
 */
public class RegexUtilsTests {

	/**
	 * Verify that we properly escape all special characters for matching regex
	 */
	@Test
	public void testRegex () {
		String s = "xxx$^[]{()}+*\\?|.xxx";
		assertEquals("xxx\\$\\^\\[\\]\\{\\(\\)\\}\\+\\*\\\\\\?\\|\\.xxx",
					 escapeRegExSpecials(s));
	}

	/**
	 * And one of the ones we are actually using
	 */
	@Test
	@Ignore // no longer relevant due to INT-1568
	public void testSiPrefix () {
		// protect the test in case we ever change the prefix
		if ("$^[]{()}+*\\?|.".contains(MessageHeaders.PREFIX)) {
			assertEquals(escapeRegExSpecials(MessageHeaders.PREFIX), "\\"
					+ MessageHeaders.PREFIX);
		}
	}

}
