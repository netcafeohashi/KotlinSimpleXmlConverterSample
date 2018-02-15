package com.example.ohashi_pc.geocodingapitest.apis.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "coordinate", strict = false)
class GeoXml {
    @set:Element(name = "coordinate")
    @get:Element(name = "coordinate")
    var coodinate: Coordinate = Coordinate()
}
