import java.util.Stack;

public class Group {
    private int[] members;
    private int[][] records;
    private int[][] teams;
    private final int memberNo;
    private final int teamNo;
    private final int teamSize;

    public Group(int m, int n) {
        memberNo = m;
        teamNo = n;
        teamSize = m / n;
        members = new int[memberNo];
        records = new int[memberNo][memberNo];
        teams = new int[teamNo][teamSize];
    }

    private void initTeams() {
        for (int i = 0; i < teamNo; i++)
            for (int j = 0; j < teamSize; j++)
                teams[i][j] = -1;
    }

    // for debug only;
    private void printTable() {
        for (int m = 0; m < memberNo; m++) {
            for (int n = 0; n < memberNo; n++) {
                System.out.print(records[m][n] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printSchedule(int[] arg) {
        Stack<Integer>[] stacks = (Stack<Integer>[]) new Stack[teamNo];
        for (int i = 0; i < teamNo; i++) stacks[i] = new Stack<Integer>();
        for (int i = 0; i < arg.length; i++) {
            stacks[arg[i]].push(i);
        }
        for (int i = 0; i < stacks.length; i++) {
            System.out.printf("team%d: ", i + 1);
            for (int index : stacks[i]) {
                System.out.print((index+1) + " ");
            }
            System.out.println();
        }
    }

    public int go() {
        int counter = 0;
        initTeams();
        while (true) {
            for (int i = 0; i < memberNo; i++) {
                int j = 0;
                for (; j < teamNo; j++) {
                    int k = 0;
                    for (; k < teamSize; k++) {
                        //choose next team if this team is already full or if somebody already in it is incompatible;
                        if (teams[j][k] == -1 || records[i][teams[j][k]] > 0) break;
                    }
                    if (k < teamSize) {
                        if (teams[j][k] == -1) {
                            //team is not full and nobody is not incompatible: put new member in this team and move on;
                            members[i] = j;
                            teams[j][k] = i;
                            for (int t = 0; t <= k; t++) {
                                records[i][teams[j][t]] = 1;
                                records[teams[j][t]][i] = 1;
                            }
                            break;
                        }
                    }
                }
                //can't find a team for this member: no further choice available, terminate; 
                if (j == teamNo) return counter;
            }
            System.out.printf("Solution %d: %n", counter + 1);
            printSchedule(members);
            members = new int[memberNo];
            counter++;
            initTeams();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough arguments supplied. Please supply: java Group member_number team_number. ");
            System.exit(1);
        }
        int member_number = Integer.parseInt(args[0]);
        int team_number = Integer.parseInt(args[1]);
        if (member_number % team_number != 0) {
            System.out.println("Current version only support member_number as multiples of team_number.");
            System.exit(1);
        }
        Group tester = new Group(member_number, team_number);
        System.out.printf("There are in total %d assignments available. %n", tester.go());
    }
}