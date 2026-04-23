```bash id="8n0ftb"
# FIRST TIME
cd <your_projects_folder>
git clone https://github.com/BaltabaiZDev/oop_project.git
cd oop_project

# put / change files here

git add .
git commit -m "Initial project"
git push origin main


# EVERY NEXT TIME
cd <your_projects_folder>/oop_project
git pull origin main
git add .
git commit -m "Update project"
git push origin main


# CHECKS
git status
git remote -v
```
