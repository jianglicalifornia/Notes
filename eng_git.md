Git commands
===========


@[git | dev]

- [eclipse path]: ~/Development/adt-bundle-mac-x86_64-20130717/eclipse/Eclipse.app/Contents/MacOS/eclipse &

**version control**
- discard unstaged changes in git: ` git stash save --keep-index` 

**branch**
- git checkout remote branches (2 steps):
    - fetch a branch: `git fetch origin`
    - get a local copy: `git checkout -b [name] origin/[name]`
- push local branch to remote: `git push origin [name]`
- view remote branches: `git branch -r`
- create a new local branch: `git checkout [name]`
- create a new local branch and switch to it: `git checkout -b [name]`
- delete branch: `git branch -d [name]` only merged branch can be deleted with `-d`. Force delete `-D`
- merge branches: `git merge [name]`  branch [name] would be merged to current branch.
- push local branch to remote: `git push origin [name]`
- delete remote branch: `git push origin :heads/[name]` or `git push origin :[name]`

