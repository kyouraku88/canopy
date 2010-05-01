Canopy.Parser.extend({
  String: new JS.Class(Canopy.Parser, {
    initialize: function(string) {
      this._string = string;
    },
    
    consume: function(input, session) {
      if (!this._begins(input, this._string)) return null;
      return this._syntaxNode(this._string, session.offset);
    }
  })
});
