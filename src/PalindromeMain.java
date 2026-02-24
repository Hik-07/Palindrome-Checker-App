import java.util.*;

public class PalindromeMain {

    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");
    }
}

public class UseCase2 {

    public static void main(String[] args) {

        String word = "madam";

        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("Word: " + word);
            System.out.println("Result: It IS a palindrome.");
        } else {
            System.out.println("Word: " + word);
            System.out.println("Result: It is NOT a palindrome.");
        }
    }
}

public class UseCase3 {

    public static void main(String[] args) {

        String word = "racecar";

        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("Word: " + word);
            System.out.println("Result: It IS a palindrome.");
        } else {
            System.out.println("Word: " + word);
            System.out.println("Result: It is NOT a palindrome.");
        }
    }
}

public class UseCase4 {

    public static void main(String[] args) {

        String word = "level";

        char[] letters = word.toCharArray();

        int start = 0;
        int end = letters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (letters[start] != letters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("Word: " + word);
            System.out.println("Result: It IS a palindrome.");
        } else {
            System.out.println("Word: " + word);
            System.out.println("Result: It is NOT a palindrome.");
        }
    }
}

import java.util.Stack;

public class UseCase5 {

    public static void main(String[] args) {

        String input = "noon";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UseCase6{

    public static void main(String[] args) {

        String input = "civic";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class UseCase7 {

    // Method to check palindrome using Deque
    public static boolean isPalindrome(String input) {

        // Convert to lowercase and remove spaces
        input = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC7: Deque-Based Palindrome Checker =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class UseCase8 {

    // Convert string to linked list
    public static Node createLinkedList(String str) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < str.length(); i++) {
            Node newNode = new Node(str.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    // Reverse linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Check palindrome using linked list
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        // Find middle using fast & slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Compare halves
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional: remove spaces and make lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        Node head = createLinkedList(input);

        if (isPalindrome(head)) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class UseCase9 {

    // Recursive method to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {

        // Base Condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters at start and end do not match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Optional: Remove spaces and convert to lowercase
        input = input.replaceAll("\\s+", "").toLowerCase();

        boolean result = isPalindrome(input, 0, input.length() - 1);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class UseCase10 {

    // Method to check palindrome (case-insensitive & space-ignored)
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        // Remove all spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply two-pointer technique
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

import java.util.Scanner;

// PalindromeChecker class encapsulates the palindrome logic
class PalindromeChecker {

    private String input;

    // Constructor to set the string
    public PalindromeChecker(String input) {
        this.input = input;
    }

    // Method to check if the string is palindrome
    public boolean checkPalindrome() {
        if (input == null || input.isEmpty()) {
            return true; // Empty string is considered a palindrome
        }

        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

public class UseCase11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Use the PalindromeChecker service class
        PalindromeChecker checker = new PalindromeChecker(input);

        if (checker.checkPalindrome()) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based implementation
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based implementation
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null || input.isEmpty()) return true;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        Deque<Character> deque = new LinkedList<>();
        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// Context class to use a strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public PalindromeCheckerContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main Application
public class UseCase12{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy:");
        System.out.println("1 - Stack-based");
        System.out.println("2 - Deque-based");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else if (choice == 2) {
            strategy = new DequeStrategy();
        } else {
            System.out.println("Invalid choice! Defaulting to StackStrategy.");
            strategy = new StackStrategy();
        }

        PalindromeCheckerContext context = new PalindromeCheckerContext(strategy);

        boolean result = context.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}

import java.util.Scanner;
import java.util.Stack;

public class UseCase13{

    // Iterative two-pointer method
    public static boolean iterativePalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;
        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive method
    public static boolean recursivePalindrome(String str, int start, int end) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        if (start >= end) return true;
        if (normalized.charAt(start) != normalized.charAt(end)) return false;
        return recursivePalindrome(normalized, start + 1, end - 1);
    }

    // Stack-based method
    public static boolean stackPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to test: ");
        String input = scanner.nextLine();

        // Iterative test
        long startTime = System.nanoTime();
        boolean iterativeResult = iterativePalindrome(input);
        long iterativeTime = System.nanoTime() - startTime;

        // Recursive test
        startTime = System.nanoTime();
        boolean recursiveResult = recursivePalindrome(input, 0, input.replaceAll("\\s+", "").length() - 1);
        long recursiveTime = System.nanoTime() - startTime;

        // Stack-based test
        startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long stackTime = System.nanoTime() - startTime;

        // Display results
        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("Iterative Method: Result=%b, Time=%d ns%n", iterativeResult, iterativeTime);
        System.out.printf("Recursive Method: Result=%b, Time=%d ns%n", recursiveResult, recursiveTime);
        System.out.printf("Stack Method:     Result=%b, Time=%d ns%n", stackResult, stackTime);

        scanner.close();
    }
}