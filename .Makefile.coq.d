demo/Maps.vo demo/Maps.glob demo/Maps.v.beautified demo/Maps.required_vo: demo/Maps.v 
demo/Maps.vio: demo/Maps.v 
demo/Maps.vos demo/Maps.vok demo/Maps.required_vos: demo/Maps.v 
demo/Syntax.vo demo/Syntax.glob demo/Syntax.v.beautified demo/Syntax.required_vo: demo/Syntax.v demo/Maps.vo
demo/Syntax.vio: demo/Syntax.v demo/Maps.vio
demo/Syntax.vos demo/Syntax.vok demo/Syntax.required_vos: demo/Syntax.v demo/Maps.vos
