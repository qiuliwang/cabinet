###1
add ignore files but it is not ignored
####tips:
git rm -r --cached . 
git add . 
git commit -m 'update .gitignore'

###2
cannot pull
####tips
git fetch --all  
git reset --hard origin/master 