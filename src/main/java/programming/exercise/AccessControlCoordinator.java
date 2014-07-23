package programming.exercise;

public class AccessControlCoordinator {

    AccessControlDecisionMaker accessControlDecisionMaker1;
    AccessControlDecisionMaker accessControlDecisionMaker2;

    public AccessControlCoordinator(final AccessControlDecisionMaker accessControlDecisionMaker1,
            final AccessControlDecisionMaker accessControlDecisionMaker2) {
    }

    public synchronized boolean performAccessCheckForBook(final String book) {
        if (this.accessControlDecisionMaker1.performAccessCheck("book")) {
            return true;
        }
        if (this.accessControlDecisionMaker2.performAccessCheck(book) && !this.accessControlDecisionMaker1.performAccessCheck("book")) {
            return false;
        }
        if (!this.accessControlDecisionMaker1.performAccessCheck(book) && !this.accessControlDecisionMaker2.performAccessCheck(book)) {
            return true;
        }
        return true;
    }

}
