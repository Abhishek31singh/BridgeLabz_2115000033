import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        VoteManager voteManager = new VoteManager();

        voteManager.addVote("Alice");
        voteManager.addVote("Bob");
        voteManager.addVote("Alice");
        voteManager.addVote("Charlie");
        voteManager.addVote("Bob");

        System.out.println("Votes in original order: " + voteManager.getVotesInOrder());
        System.out.println("Votes sorted by candidate: " + voteManager.getVotesSortedByCandidate());
        System.out.println("Votes sorted by vote count: " + voteManager.getVotesSortedByVotes());
    }
}

class VoteManager {
    private Map<String, Integer> votes = new HashMap<>();
    private Map<String, Integer> votesInOrder = new LinkedHashMap<>();
    private Map<String, Integer> sortedVotes = new TreeMap<>();

    public void addVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        votesInOrder.put(candidate, votes.get(candidate));
        sortedVotes.put(candidate, votes.get(candidate));
    }

    public Map<String, Integer> getVotesInOrder() {
        return votesInOrder;
    }

    public Map<String, Integer> getVotesSortedByCandidate() {
        return sortedVotes;
    }

    public Map<String, Integer> getVotesSortedByVotes() {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(votes.entrySet());
        sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Map<String, Integer> sortedByVotes = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            sortedByVotes.put(entry.getKey(), entry.getValue());
        }

        return sortedByVotes;
    }
}
