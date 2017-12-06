import java.io.File


fun readCsvFileKotlin(csvFile:String):String {
    var reader = File(csvFile).readLines()//[1:]
    var a = StringBuilder()
    var prefix:String =""
    for (line in reader) {
        val mbrProperties = line.split(",")
        a.append(prefix)
        a.append("("+mbrProperties[0]+","+mbrProperties[1]+",'"+mbrProperties[2]+"','"+mbrProperties[3]+"')")
        prefix=","
    }
    return a.toString()
}