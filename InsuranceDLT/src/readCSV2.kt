import java.io.File

fun String.isNumeric(): Boolean {
    return this.matches("\\d+".toRegex())
}

fun readCsvFileKotlin(csvFile:String):String {
    var reader = File(csvFile).readLines()
    var a = StringBuilder()
    var prefix:String =""
    for (line in reader) {
        val mbrProperties = line.split(",")
        a.append(prefix)
        if (mbrProperties[8].isNumeric()){
            a.append("('"+mbrProperties[0]+"','"+mbrProperties[1]+"','"+mbrProperties[2]+"','"+mbrProperties[3]+"','"+mbrProperties[4]+"','"+mbrProperties[5]+"','"+mbrProperties[6]+"','"+mbrProperties[7]+"','"+mbrProperties[8]+"')")
            prefix=","
        }else{
            println("Exclude from insert"+"('"+mbrProperties[0]+"','"+mbrProperties[1]+"','"+mbrProperties[2]+"','"+mbrProperties[3]+"','"+mbrProperties[4]+"','"+mbrProperties[5]+"','"+mbrProperties[6]+"','"+mbrProperties[7]+"','"+mbrProperties[8]+"')")
        }
    }
    println(a.toString())
    return a.toString()
}
