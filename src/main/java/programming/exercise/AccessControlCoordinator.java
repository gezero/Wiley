package programming.exercise;

import static com.google.common.base.Preconditions.checkNotNull;

public class AccessControlCoordinator {

    AccessControlDecisionMaker accessControlDecisionMaker1;
    AccessControlDecisionMaker accessControlDecisionMaker2;

    public synchronized boolean performAccessCheckForBook(final String book) {
        checkNotNull(book);
        if (this.accessControlDecisionMaker1.performAccessCheck(book)) {
            return true;
        }
        return this.accessControlDecisionMaker2.performAccessCheck(book);
    }

    public void setAccessControlDecisionMaker1(AccessControlDecisionMaker accessControlDecisionMaker1) {
        this.accessControlDecisionMaker1 = accessControlDecisionMaker1;
    }

    public void setAccessControlDecisionMaker2(AccessControlDecisionMaker accessControlDecisionMaker2) {
        this.accessControlDecisionMaker2 = accessControlDecisionMaker2;
    }
}
