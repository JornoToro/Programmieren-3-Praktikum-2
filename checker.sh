echo "--- ElderlyMain: starting Checkstyle ---"
java -jar libs/checkstyle-8.25-all.jar -c checkers_xml/checkstyle.xml src/Aufgabe2/ElderlyMain.java
echo "--- ElderlyMain:  starting PMD ---"
libs/pmd-bin-6.18.0/bin/run.sh pmd  -no-cache -d src/Aufgabe2/ElderlyMain.java -f text  -R checkers_xml/pmd.xml
echo "____________________________________________________________________"
echo "--- LicenceAdministration: starting Checkstyle ---"
