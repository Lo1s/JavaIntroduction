package chapter22;

import java.util.Stack;
import java.util.StringTokenizer;

public class Exercise22_19
{
    public static class EvaluateExpression
    {

        @SuppressWarnings({ "rawtypes", "unchecked" })
		public static double evaluateExpression(String expression)
        {
            Stack operandStack = new Stack();
            Stack operatorStack = new Stack();
            for(StringTokenizer tokens = new StringTokenizer(expression, "()+-/*", true); tokens.hasMoreTokens();)
            {
                String token = tokens.nextToken().trim();
                if(token.length() != 0)
                {
                    if(token.charAt(0) == '+' || token.charAt(0) == '-')
                    {
                        for(; !operatorStack.isEmpty() && (((Character)operatorStack.peek()).equals(Character.valueOf('+')) || ((Character)operatorStack.peek()).equals(Character.valueOf('-')) || ((Character)operatorStack.peek()).equals(Character.valueOf('*')) || ((Character)operatorStack.peek()).equals(Character.valueOf('/'))); processAnOperator(operandStack, operatorStack)) { }
                        operatorStack.push(new Character(token.charAt(0)));
                    } else
                    if(token.charAt(0) == '*' || token.charAt(0) == '/')
                    {
                        for(; !operatorStack.isEmpty() && (((Character)operatorStack.peek()).equals(Character.valueOf('*')) || ((Character)operatorStack.peek()).equals(Character.valueOf('/'))); processAnOperator(operandStack, operatorStack)) { }
                        operatorStack.push(new Character(token.charAt(0)));
                    } else
                    if(token.trim().charAt(0) == '(')
                    {
                        operatorStack.push(new Character('('));
                    } else
                    if(token.trim().charAt(0) == ')')
                    {
                        for(; !((Character)operatorStack.peek()).equals(Character.valueOf('(')); processAnOperator(operandStack, operatorStack)) { }
                        operatorStack.pop();
                    } else
                    {
                        operandStack.push(new Double(token));
                    }
                }
            }

            for(; !operatorStack.isEmpty(); processAnOperator(operandStack, operatorStack)) { }
            return ((Double)operandStack.pop()).doubleValue();
        }

        @SuppressWarnings({ "unchecked", "rawtypes" })
		public static void processAnOperator(Stack operandStack, Stack operatorStack)
        {
            if(((Character)operatorStack.peek()).equals(Character.valueOf('+')))
            {
                operatorStack.pop();
                double op1 = ((Double)operandStack.pop()).doubleValue();
                double op2 = ((Double)operandStack.pop()).doubleValue();
                operandStack.push(new Double(op2 + op1));
            } else
            if(((Character)operatorStack.peek()).equals(Character.valueOf('-')))
            {
                operatorStack.pop();
                double op1 = ((Double)operandStack.pop()).doubleValue();
                double op2 = ((Double)operandStack.pop()).doubleValue();
                operandStack.push(new Double(op2 - op1));
            } else
            if(((Character)operatorStack.peek()).equals(Character.valueOf('*')))
            {
                operatorStack.pop();
                double op1 = ((Double)operandStack.pop()).doubleValue();
                double op2 = ((Double)operandStack.pop()).doubleValue();
                operandStack.push(new Double(op2 * op1));
            } else
            if(((Character)operatorStack.peek()).equals(Character.valueOf('/')))
            {
                operatorStack.pop();
                double op1 = ((Double)operandStack.pop()).doubleValue();
                double op2 = ((Double)operandStack.pop()).doubleValue();
                operandStack.push(new Double(op2 / op1));
            }
        }

        public EvaluateExpression()
        {
        }
    }


    public Exercise22_19()
    {
    }

    public static void main(String args[])
    {
        int deck[] = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 
            11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 
            8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 
            5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 
            2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 
            12, 13
        };
        long startTime = System.currentTimeMillis();
        int totalNumberOfCombinations = 0;
        int solutionCount = 0;
        for(int i1 = 0; i1 < deck.length; i1++)
        {
            for(int i2 = i1 + 1; i2 < deck.length; i2++)
            {
                for(int i3 = i2 + 1; i3 < deck.length; i3++)
                {
                    for(int i4 = i3 + 1; i4 < deck.length; i4++)
                    {
                        totalNumberOfCombinations++;
                        int a = deck[i1];
                        int b = deck[i2];
                        int c = deck[i3];
                        int d = deck[i4];
                        String s = findSolution(a, b, c, d);
                        if(!s.equals("No solution"))
                        {
                            solutionCount++;
                            double percentage = (((double)solutionCount / (double)totalNumberOfCombinations) * 100.00);
                            System.out.println("Total: " + totalNumberOfCombinations + ", Solutions: " + solutionCount + ", Percentage: " + percentage + "%");
                        }
                    }

                }

            }

        }

        System.out.println((new StringBuilder("Total number of combinations is ")).append(totalNumberOfCombinations).toString());
        System.out.println((new StringBuilder("Total number of combinations with solutions is ")).append(solutionCount).toString());
        System.out.println((new StringBuilder("The solution ratio is ")).append((1.0D * (double)solutionCount) / (double)totalNumberOfCombinations).toString());
        long endTime = System.currentTimeMillis();
        System.out.println((new StringBuilder("Total time spent ")).append((endTime - startTime) / 1000L).toString());
    }

    public static String findSolution(int a, int b, int c, int d)
    {
        String noSolution = "No solution";
        String operators[] = {
            "+", "-", "*", "/"
        };
        int allCombinations[][] = {
            {
                a, b, c, d
            }, {
                d, a, b, c
            }, {
                c, d, a, b
            }, {
                b, c, d, a
            }, {
                a, b, d, c
            }, {
                c, a, b, d
            }, {
                d, c, a, b
            }, {
                b, d, c, a
            }, {
                a, d, c, b
            }, {
                b, a, d, c
            }, {
                c, b, a, d
            }, {
                d, c, b, a
            }, {
                a, c, b, d
            }, {
                d, a, c, b
            }, {
                b, d, a, c
            }, {
                c, b, d, a
            }, {
                b, a, c, d
            }, {
                d, b, a, c
            }, {
                c, d, b, a
            }, {
                a, c, d, b
            }, {
                a, d, b, c
            }, {
                c, a, d, b
            }, {
                b, c, a, d
            }, {
                d, b, c, a
            }
        };
        String as[];
        int l = (as = operators).length;
        for(int k = 0; k < l; k++)
        {
            String firstOp = as[k];
            String as1[];
            int j1 = (as1 = operators).length;
            for(int i1 = 0; i1 < j1; i1++)
            {
                String secondOp = as1[i1];
                String as2[];
                int l1 = (as2 = operators).length;
                for(int k1 = 0; k1 < l1; k1++)
                {
                    String thirdOp = as2[k1];
                    int ai[][];
                    int j2 = (ai = allCombinations).length;
                    for(int i2 = 0; i2 < j2; i2++)
                    {
                        int cardNums[] = ai[i2];
                        for(int i = 0; i < 3; i++)
                        {
                            for(int j = 0; j < 5; j++)
                            {
                                if(i == 0)
                                {
                                    if(j == 0)
                                    {
                                        String solution = (new StringBuilder(String.valueOf(cardNums[0]))).append(firstOp).append(cardNums[1]).append(secondOp).append(cardNums[2]).append(thirdOp).append(cardNums[3]).toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 1)
                                    {
                                        String solution = (new StringBuilder("(")).append(cardNums[0]).append(firstOp).append(cardNums[1]).append(")").append(secondOp).append(cardNums[2]).append(thirdOp).append(cardNums[3]).toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 2)
                                    {
                                        String solution = (new StringBuilder(String.valueOf(cardNums[0]))).append(firstOp).append("(").append(cardNums[1]).append(secondOp).append(cardNums[2]).append(")").append(thirdOp).append(cardNums[3]).toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 3)
                                    {
                                        String solution = (new StringBuilder(String.valueOf(cardNums[0]))).append(firstOp).append(cardNums[1]).append(secondOp).append("(").append(cardNums[2]).append(thirdOp).append(cardNums[3]).append(")").toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 4)
                                    {
                                        String solution = (new StringBuilder("(")).append(cardNums[0]).append(firstOp).append(cardNums[1]).append(")").append(secondOp).append("(").append(cardNums[2]).append(thirdOp).append(cardNums[3]).append(")").toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    }
                                } else
                                if(i == 1)
                                {
                                    if(j == 0)
                                    {
                                        String solution = (new StringBuilder("(")).append(cardNums[0]).append(firstOp).append(cardNums[1]).append(secondOp).append(cardNums[2]).append(")").append(thirdOp).append(cardNums[3]).toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 1)
                                    {
                                        String solution = (new StringBuilder("((")).append(cardNums[0]).append(firstOp).append(cardNums[1]).append(")").append(secondOp).append(cardNums[2]).append(")").append(thirdOp).append(cardNums[3]).toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 2)
                                    {
                                        String solution = (new StringBuilder("(")).append(cardNums[0]).append(firstOp).append("(").append(cardNums[1]).append(secondOp).append(cardNums[2]).append("))").append(thirdOp).append(cardNums[3]).toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    }
                                } else
                                if(i == 2)
                                {
                                    if(j == 0)
                                    {
                                        String solution = (new StringBuilder(String.valueOf(cardNums[0]))).append(firstOp).append("(").append(cardNums[1]).append(secondOp).append(cardNums[2]).append(thirdOp).append(cardNums[3]).append(")").toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 1)
                                    {
                                        String solution = (new StringBuilder(String.valueOf(cardNums[0]))).append(firstOp).append("((").append(cardNums[1]).append(secondOp).append(cardNums[2]).append(")").append(thirdOp).append(cardNums[3]).append(")").toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    } else
                                    if(j == 2)
                                    {
                                        String solution = (new StringBuilder(String.valueOf(cardNums[0]))).append(firstOp).append("(").append(cardNums[1]).append(secondOp).append("(").append(cardNums[2]).append(thirdOp).append(cardNums[3]).append("))").toString();
                                        if(EvaluateExpression.evaluateExpression(solution) == 24D)
                                        {
                                            return solution;
                                        }
                                    }
                                }
                            }

                        }

                    }

                }

            }

        }

        return noSolution;
    }
}