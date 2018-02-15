package com.example.ohashi_pc.geocodingapitest.apis.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "coordinate", strict = false)
class Coordinate {
    @set:Element(name = "lat")
    @get:Element(name = "lat")
    var latitudem: String = ""

    @set:Element(name = "lng")
    @get:Element(name = "lng")
    var longitudem: String = ""
}