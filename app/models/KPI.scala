case class KPIValue (timestamp: Date,
	 				 value: Double)

case class KPI (name: String,
	           description: String,
	           owner: String,
	           target: Double,
	           deadline: Date,
	           historicalValues: List[KPIValue])