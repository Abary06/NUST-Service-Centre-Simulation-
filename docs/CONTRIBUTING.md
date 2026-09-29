# Team Contribution Workflow

## Four-member task split

Each member owns one focused area. Coordinate changes to `src/Main.java` and shared documentation with the group before editing them, since they connect multiple areas.

| Member | Task | Primary files |
| --- | --- | --- |
| Member 1 | Student model and waiting queue | `src/model/Student.java`, `src/queue/StudentQueue.java` |
| Member 2 | Student service-record linked list | `src/linkedlist/StudentLinkedList.java`, `src/linkedlist/StudentNode.java` |
| Member 3 | Custom stack and postfix evaluation | `src/stack/CustomStack.java`, `src/stack/PostfixDemo.java` |
| Member 4 | Sorting, statistics, and experiment | `src/sorting/`, `src/statistics/ServiceStatistics.java`, `src/experiment/SortingExperiment.java` |

Use the real member names in GitHub pull requests and, if appropriate, in the project roster. These role labels are placeholders, not GitHub identities.

## Per-member workflow

Each member needs their own GitHub account and write access to this repository. They should clone the repository to their own working copy and set the author identity locally, using the name and an email address associated with their GitHub account:

```powershell
git clone <repository-url>
cd NUST-Service-Centre-Simulation-
git config user.name "Your Name"
git config user.email "your-verified-github-email"
git config --get user.name
git config --get user.email
```

Start a separate branch for the assigned task, make and test its changes, and commit only that task's files. For example, Member 1 can use:

```powershell
git switch -c task/member-1-queue
git add src/model/Student.java src/queue/StudentQueue.java
git commit -m "Implement student queue"
git push -u origin task/member-1-queue
```

Suggested branch names are `task/member-1-queue`, `task/member-2-linked-list`, `task/member-3-stack`, and `task/member-4-sorting`. Each member opens a pull request from their branch into the repository's default branch; review and merge each pull request there.

GitHub attributes commits using their author email, not the branch name or commit message. Do not use another member's account or set the author to a placeholder identity. Commits become part of the default-branch history when merged; changing local author settings does not change attribution on commits already made.

## Remote prerequisite

Before pushing, confirm that the repository URL is correct, each member has access, and the default branch exists on GitHub. In the current workspace, `origin/main` is marked gone and the remote returned no branch refs, so check remote access and the default branch before pushing.