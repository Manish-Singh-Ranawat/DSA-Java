// Design Browser History - https://leetcode.com/problems/design-browser-history/description/

// You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

// Implement the BrowserHistory class:

// BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
// void visit(string url) Visits url from the current page. It clears up all the forward history.
// string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
// string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

// Input:
// ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
// [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]

// Output:
// [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

// Explanation:
// BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
// browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
// browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
// browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
// browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
// browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
// browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
// browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
// browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
// browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
// browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

class Node {
    String data;
    Node prev;
    Node next;

    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
// -------------------------

public class BrowserHistory {
    Node currentPage;

    public BrowserHistory(String homepage) {
        this.currentPage = new Node(homepage);
    }

    public void visit(String url) {
        Node visit = new Node(url);
        visit.prev = currentPage;
        currentPage.next = visit;
        currentPage = currentPage.next;
    }

    public String back(int steps) {
        while (steps > 0 && currentPage.prev != null) {
            steps--;
            currentPage = currentPage.prev;
        }
        return currentPage.data;
    }

    public String forward(int steps) {
        while (steps > 0 && currentPage.next != null) {
            steps--;
            currentPage = currentPage.next;
        }
        return currentPage.data;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        System.out.println("BrowserHistory created with homepage: leetcode.com");

        browserHistory.visit("google.com");
        System.out.println("Visited: google.com");

        browserHistory.visit("facebook.com");
        System.out.println("Visited: facebook.com");

        browserHistory.visit("youtube.com");
        System.out.println("Visited: youtube.com");

        System.out.println("Back 1: " + browserHistory.back(1));
        System.out.println("Back 1: " + browserHistory.back(1));
        System.out.println("Forward 1: " + browserHistory.forward(1));

        browserHistory.visit("linkedin.com");
        System.out.println("Visited: linkedin.com");

        System.out.println("Forward 2: " + browserHistory.forward(2));
        System.out.println("Back 2: " + browserHistory.back(2));
        System.out.println("Back 7: " + browserHistory.back(7));
    }
}