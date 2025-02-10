# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?
   Comma-Separated Values.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
   Because List is an interface of ArrayList so declaring it as List will provide more compatibility with other implementations of List.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
   has-a

4. Can you provide an example of a has-a relationship in your code (if one exists)?
    SalaryEmployee class has a name


5. Can you provide an example of an is-a relationship in your code (if one exists)? 
    SalaryEmployee is a IEmployee


6. What is the difference between an interface and an abstract class?
    An interface is a contract that classes must implement.
    An abstract class is a partially implemented class that subclasses extend.

7. What is the advantage of using an interface over an abstract class?
    Interface can offer more flexibility and multiple inheritance than abstract class.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it.
   ArrayList<int> is not allowed in java.
   List<Integer> numbers = new ArrayList<Integer>();

9. Which class/method is described as the "driver" for your application? 
    main() in PayrollGenerator class

10. How do you create a temporary folder for JUnit Testing? 
    TempDir


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

1.To implement this, several additional data points should be stored in the employee records, including gender, years of experience, race, education level, job role. So we can track is there any inequality base on gander or any different race.And base on data, how big is this inequality?
•	Blau, F. D., & Kahn, L. M. (2017). “The Gender Wage Gap: Extent, Trends, and Explanations.” Journal of Economic Literature, 55(3), 789-865.
•	McKinsey & Company. (2020). “Diversity Wins: How Inclusion Matters.” Retrieved from www.mckinsey.com
