#!/bin/sh
echo "Building Infrared"
echo "...Cleaning Build Directory"
rm -rf ./build
mkdir build

echo "...Creating Build Templates"
echo "#!/bin/sh
kotlin -classpath ./build/infrared.jar CLASS" > ./build/kotlin.template

echo "...Entering Build Directory"
cd build
echo "...Compiling Kotlin Source"
kotlinc ../src -d infrared
echo "...Compiling Java Source"
javac $(find ../src/ | rg .java) -d infrared
echo "...Building Jar"
cd infrared
jar cf ../infrared.jar -C "." $(find ./* | rg .class)
cd ../
echo "...Creating Run Scripts"
cat kotlin.template | sed 's/CLASS/io.github.jgbyrne.core.MainKt/' > main; chmod +x main
echo "       build/main"
cat kotlin.template | sed 's/CLASS/terrain.TerrainKt/' > terrain; chmod +x terrain
echo "       build/terrain"
echo "...Leaving Build Directory"
cd ..
echo "Done!"
