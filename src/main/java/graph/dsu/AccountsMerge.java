package graph.dsu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> emailToAccount = new HashMap<>();

        // Union accounts that share at least one email
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccount.containsKey(email)) {
                    ds.unionBySize(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        // Group all emails under their DSU root account index
        Map<Integer, List<String>> emailsByRoot = new HashMap<>();
        for (var entry : emailToAccount.entrySet()) {
            int root = ds.findRoot(entry.getValue());
            emailsByRoot.computeIfAbsent(root, k -> new ArrayList<>()).add(entry.getKey());
        }

        // Build result: sort emails, prepend the account owner's name
        List<List<String>> result = new ArrayList<>();
        for (var entry : emailsByRoot.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            emails.addFirst(accounts.get(entry.getKey()).getFirst());
            result.add(emails);
        }

        return result;
    }

    public static void main(String[] args) {
        AccountsMerge am = new AccountsMerge();

        List<List<String>> accounts = List.of(
                List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("Mary","mary@mail.com"),
                List.of("John","johnnybravo@mail.com")
        );

        System.out.println(am.accountsMerge(accounts));
    }
}
