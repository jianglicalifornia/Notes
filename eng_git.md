Git commands
===========


@[git | dev]

**commands**
- [eclipse path]: `~/Development/adt-bundle-mac-x86_64-20130717/eclipse/Eclipse.app/Contents/MacOS/eclipse &`

**version control**
- discard unstaged changes in git: ` git stash save --keep-index` 
- discard local commit: `git reset --hard origin/master`
- change last commit message: `git commit --amend -m "New commit message"`
- get back to most recent version: `git checkout master`
- go back two versions: `git checkout HEAD~2`
- create a temporary branch based on 2 versions back: `git checkout -b temp_branch HEAD~2`

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

**code checkin**
- commit a single file/directory: `git commit -m 'my notes' -- path/to/my/file.ext`

**stash**
- creating a branch from a stash: `git stash branch testchanges`
- list stash: `git stash list`
- apply stash: `git stash apply stash@{2}`
- drop stash: `git stash drop stash@{0}`

**history**
- view the commit history: `git log`
- advanced version: `git log --pretty="%h - %s" --author=gitster --since="2008-10-01" --before="2008-11-01" --no-merges -- t/`

**compare**
- 
compare local git branch with remote branch: `git diff <local branch> <remote-tracking branch>` `git diff master origin/master`


