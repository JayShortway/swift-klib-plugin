package io.github.ttypic.swiftklib.gradle.templates

internal fun createPackageSwiftContents(
    cinteropName: String,
    defaultLocalization: String?,
): String = """
    // swift-tools-version:5.5
    import PackageDescription

    let package = Package(
        name: "$cinteropName",
        ${defaultLocalization?.let { "defaultLocalization: \"$defaultLocalization\"" } ?: ""}
        products: [
            .library(
                name: "$cinteropName",
                type: .static,
                targets: ["$cinteropName"])
        ],
        dependencies: [],
        targets: [
            .target(
                name: "$cinteropName",
                dependencies: [],
                path: "$cinteropName")
        ]
    )
""".trimIndent()
