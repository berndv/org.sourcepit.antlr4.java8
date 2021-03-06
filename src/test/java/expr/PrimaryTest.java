/*
 * Copyright 2015 Bernd Vogt and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package expr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.expr.Expression;

import expr.ExprParser.PrimaryContext;

public class PrimaryTest {

   @Test
   public void test() throws ParseException {
      // new [TypeArguments] {Annotation} Identifier [TypeArgumentsOrDiamond] ( [ArgumentList] ) [ClassBody]
      Expression expr = JavaParser.parseExpression("expressionName.foo");
      System.out.println(expr);

      ExprParser exprParser = new ExprParser(new CommonTokenStream(new ExprLexer(new ANTLRInputStream(
         "expressionName.foo"))));
      exprParser.setTrace(true);
      
      PrimaryContext primary = exprParser.primary();
      System.out.println(primary);

      expr = JavaParser.parseExpression("new int[] []{}");
      System.out.println(expr);
   }
}
