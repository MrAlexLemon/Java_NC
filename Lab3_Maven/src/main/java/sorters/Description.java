package sorters;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description{
    String name(); //The command for which the function will answer

    String args(); //Function arguments

    int minArgs() default 0; //Minimum number of arguments

    String desc(); //Description

    int maxArgs() default Integer.MAX_VALUE; //The maximum number of arguments

    boolean showInHelp() default true; //Show the command in the list

    String[] aliases(); //Which command will be considered equivalent to ours
}
