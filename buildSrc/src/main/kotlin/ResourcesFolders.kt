//Android studio says that the resource is not used, but this is not true. it is used in app's build gradle.
//This bug was introduced in 3.3 version. It stopped to work correctly with Kotlin DSL

object ResourcesFolders {

    val dirs = arrayListOf(
        "src/main/res-screens/main",
        "src/main/res-screens/main/fragments"
    )
}
