package logic;

import entity.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateManager {
    private List<Candidate> candidateList = new ArrayList<>();

    public void addCandidate(Candidate c) {
        candidateList.add(c);
    }

    public List<Candidate> getAllCandidates() {
        return candidateList;
    }

    public List<Candidate> search(String name, int type) {
        List<Candidate> result = new ArrayList<>();
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == type &&
                (c.getFullName().toLowerCase().contains(name.toLowerCase()))) {
                result.add(c);
            }
        }
        return result;
    }

    public void displayGroupedCandidates() {
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 0) System.out.println(c.getFullName());
        }

        System.out.println("===========FRESHER CANDIDATE==============");
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 1) System.out.println(c.getFullName());
        }

        System.out.println("===========INTERN CANDIDATE===============");
        for (Candidate c : candidateList) {
            if (c.getCandidateType() == 2) System.out.println(c.getFullName());
        }
    }
}
