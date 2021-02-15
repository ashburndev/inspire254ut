# inspire254ut

This project was created to explore the unit testing functionality of a Grails 2.5.4 web application.

```
cd "\Users\David Holberton\g2mprojects"
grails create-app inspire254ut
cd inspire254ut
dir /o:gd
grails integrate-with --eclipse --intellij --textmate --ant --git
tree /a    > ..\..\inspire254ut-tree-a.txt
tree /a /f > ..\..\inspire254ut-tree-af.txt
git init
git add .
git commit -a -m "initial commit"
git status

REM ssh
git remote add origin git@github.com:ashburndev/inspire254ut.git
git branch -M main
git push -u origin main

REM https
git remote add origin https://github.com/ashburndev/inspire254ut.git
git branch -M main
git push -u origin main

git status

grails create-domain-class inspire.Case
grails create-domain-class inspire.CaseStatus
grails create-domain-class inspire.CaseSection
grails create-domain-class inspire.EducationRecord
grails create-domain-class inspire.EmploymentRecord
git add .
git commit -a -m "add domain classes"

grails refresh-dependencies

grails generate-all inspire.Case
grails generate-all inspire.CaseStatus
grails generate-all inspire.CaseSection
grails generate-all inspire.EducationRecord
grails generate-all inspire.EmploymentRecord

grails create-service inspire.Case
grails create-service inspire.CaseStatus
grails create-service inspire.CaseSection
grails create-service inspire.EducationRecord
grails create-service inspire.EmploymentRecord
git add .
git commit -a -m "add controller and service classes"

grails clean
rmdir /s /q target
tree /a    > ..\..\inspire254ut-tree-a2.txt
tree /a /f > ..\..\inspire254ut-tree-af2.txt
grails stats
git log --pretty=format:"%h - %an, %ai : %s"

grails refresh-dependencies

grails schema-export
copy target\ddl.sql ..\..\inspire254ut-ddl.sql
grails dependency-report > ..\..\inspire254ut.dependency.report
copy ..\..\inspire254ut* .
git add .
git commit -a -m "add documentation artifacts"
grails status
git log --pretty=format:"%h - %an, %ai : %s"
dir /o:gd

grails run-app
```

```
C:\>
C:\>cd "\Users\David Holberton\g2mprojects"

| Created Grails Application at C:\Users\David Holberton\g2mprojects\inspire254ut

C:\Users\David Holberton\g2mprojects>cd inspire254ut

C:\Users\David Holberton\g2mprojects\inspire254ut>dir /o:gd
 Volume in drive C has no label.
 Volume Serial Number is 4603-A8D3

 Directory of C:\Users\David Holberton\g2mprojects\inspire254ut

02/15/2021  07:22 AM    <DIR>          src
02/15/2021  07:22 AM    <DIR>          test
02/15/2021  07:22 AM    <DIR>          scripts
02/15/2021  07:22 AM    <DIR>          lib
02/15/2021  07:22 AM    <DIR>          web-app
02/15/2021  07:22 AM    <DIR>          grails-app
02/15/2021  07:22 AM    <DIR>          wrapper
02/15/2021  07:22 AM    <DIR>          .
02/15/2021  07:22 AM    <DIR>          ..
02/15/2021  07:22 AM             1,003 .classpath
02/15/2021  07:22 AM               485 .project
02/15/2021  07:22 AM               120 application.properties
02/15/2021  07:22 AM             9,604 grailsw
02/15/2021  07:22 AM             5,972 grailsw.bat
               5 File(s)         17,184 bytes
               9 Dir(s)  42,856,108,032 bytes free

C:\Users\David Holberton\g2mprojects\inspire254ut>
C:\Users\David Holberton\g2mprojects\inspire254ut>git remote add origin https://github.com/ashburndev/inspire254ut.git
C:\Users\David Holberton\g2mprojects\inspire254ut>git branch -M main
C:\Users\David Holberton\g2mprojects\inspire254ut>git push -u origin main
Enumerating objects: 85, done.
Counting objects: 100% (85/85), done.
Delta compression using up to 8 threads
Compressing objects: 100% (80/80), done.
Writing objects: 100% (85/85), 494.70 KiB | 10.10 MiB/s, done.
Total 85 (delta 2), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (2/2), done.
To https://github.com/ashburndev/inspire254ut.git
 * [new branch]      main -> main
Branch 'main' set up to track remote branch 'main' from 'origin'.

C:\Users\David Holberton\g2mprojects\inspire254ut>
C:\Users\David Holberton\g2mprojects\inspire254ut>grails stats

| Environment set to development....

    +----------------------+-------+-------+
    | Name                 | Files |  LOC  |
    +----------------------+-------+-------+
    | Controllers          |     5 |   410 |
    | Domain Classes       |     5 |    25 |
    | Services             |     5 |    35 |
    | Unit Tests           |    15 |   695 |
    +----------------------+-------+-------+
    | Totals               |    30 |  1165 |
    +----------------------+-------+-------+


C:\Users\David Holberton\g2mprojects\inspire254ut>git log --pretty=format:"%h - %an, %ai : %s"
c3554d0 - ashburndev, 2021-02-15 07:39:04 -0500 : add documentation artifacts
29b2e26 - ashburndev, 2021-02-15 07:34:21 -0500 : add controller and service classes
cf29241 - ashburndev, 2021-02-15 07:31:49 -0500 : add domain classes
935e349 - ashburndev, 2021-02-15 07:24:59 -0500 : initial commit

C:\Users\David Holberton\g2mprojects\inspire254ut>dir /o:gd
 Volume in drive C has no label.
 Volume Serial Number is 4603-A8D3

 Directory of C:\Users\David Holberton\g2mprojects\inspire254ut

02/15/2021  07:22 AM    <DIR>          src
02/15/2021  07:22 AM    <DIR>          scripts
02/15/2021  07:22 AM    <DIR>          test
02/15/2021  07:22 AM    <DIR>          lib
02/15/2021  07:22 AM    <DIR>          web-app
02/15/2021  07:22 AM    <DIR>          wrapper
02/15/2021  07:32 AM    <DIR>          grails-app
02/15/2021  07:38 AM    <DIR>          target
02/15/2021  07:38 AM    <DIR>          ..
02/15/2021  07:38 AM    <DIR>          .
02/15/2021  07:22 AM             1,003 .classpath
02/15/2021  07:22 AM               485 .project
02/15/2021  07:22 AM               120 application.properties
02/15/2021  07:22 AM             9,604 grailsw
02/15/2021  07:22 AM             5,972 grailsw.bat
02/15/2021  07:23 AM               215 .gitignore
02/15/2021  07:23 AM               741 ivysettings.xml
02/15/2021  07:23 AM             5,383 build.xml
02/15/2021  07:23 AM               666 ivy.xml
02/15/2021  07:23 AM             2,747 inspire254ut.iws
02/15/2021  07:23 AM             2,540 inspire254ut.iml
02/15/2021  07:23 AM            12,660 inspire254ut.ipr
02/15/2021  07:23 AM             2,290 inspire254ut.tmproj
02/15/2021  07:23 AM               652 inspire254ut-tree-a.txt
02/15/2021  07:23 AM             3,007 inspire254ut-tree-af.txt
02/15/2021  07:35 AM               833 inspire254ut-tree-a2.txt
02/15/2021  07:35 AM             5,384 inspire254ut-tree-af2.txt
02/15/2021  07:38 AM               950 inspire254ut-ddl.sql
02/15/2021  07:38 AM            17,639 inspire254ut.dependency.report
              19 File(s)         72,891 bytes
              10 Dir(s)  42,722,451,456 bytes free

C:\Users\David Holberton\g2mprojects\inspire254ut>
```

