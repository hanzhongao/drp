(function () {
    var l;

    function aa(a) {
        var b = 0;
        return function () {
            return b < a.length ? {done: !1, value: a[b++]} : {done: !0}
        }
    }

    function ba(a) {
        var b = "undefined" != typeof Symbol && Symbol.iterator && a[Symbol.iterator];
        return b ? b.call(a) : {next: aa(a)}
    }

    var ca = "function" == typeof Object.create ? Object.create : function (a) {
        function b() {
        }

        b.prototype = a;
        return new b
    }, da;
    if ("function" == typeof Object.setPrototypeOf) da = Object.setPrototypeOf; else {
        var ea;
        a:{
            var fa = {Da: !0}, ha = {};
            try {
                ha.__proto__ = fa;
                ea = ha.Da;
                break a
            } catch (a) {
            }
            ea = !1
        }
        da = ea ? function (a, b) {
            a.__proto__ = b;
            if (a.__proto__ !== b) throw new TypeError(a + " is not extensible");
            return a
        } : null
    }
    var ia = da;

    function ja(a, b) {
        a.prototype = ca(b.prototype);
        a.prototype.constructor = a;
        if (ia) ia(a, b); else for (var c in b) if ("prototype" != c) if (Object.defineProperties) {
            var d = Object.getOwnPropertyDescriptor(b, c);
            d && Object.defineProperty(a, c, d)
        } else a[c] = b[c];
        a.Wa = b.prototype
    }

    var ka = "function" == typeof Object.defineProperties ? Object.defineProperty : function (a, b, c) {
            a != Array.prototype && a != Object.prototype && (a[b] = c.value)
        },
        la = "undefined" != typeof window && window === this ? this : "undefined" != typeof global && null != global ? global : this;

    function ma(a, b) {
        if (b) {
            var c = la;
            a = a.split(".");
            for (var d = 0; d < a.length - 1; d++) {
                var e = a[d];
                e in c || (c[e] = {});
                c = c[e]
            }
            a = a[a.length - 1];
            d = c[a];
            b = b(d);
            b != d && null != b && ka(c, a, {configurable: !0, writable: !0, value: b})
        }
    }

    ma("String.prototype.endsWith", function (a) {
        return a ? a : function (b, c) {
            if (null == this) throw new TypeError("The 'this' value for String.prototype.endsWith must not be null or undefined");
            if (b instanceof RegExp) throw new TypeError("First argument to String.prototype.endsWith must not be a regular expression");
            void 0 === c && (c = this.length);
            c = Math.max(0, Math.min(c | 0, this.length));
            for (var d = b.length; 0 < d && 0 < c;) if (this[--c] != b[--d]) return !1;
            return 0 >= d
        }
    });
    ma("Array.prototype.find", function (a) {
        return a ? a : function (b, c) {
            a:{
                var d = this;
                d instanceof String && (d = String(d));
                for (var e = d.length, f = 0; f < e; f++) {
                    var g = d[f];
                    if (b.call(c, g, f, d)) {
                        b = g;
                        break a
                    }
                }
                b = void 0
            }
            return b
        }
    });
    var na = "function" == typeof Object.assign ? Object.assign : function (a, b) {
        for (var c = 1; c < arguments.length; c++) {
            var d = arguments[c];
            if (d) for (var e in d) Object.prototype.hasOwnProperty.call(d, e) && (a[e] = d[e])
        }
        return a
    };
    ma("Object.assign", function (a) {
        return a || na
    });
    var p = this || self;

    function r(a) {
        return "string" == typeof a
    }

    function oa(a) {
        return "number" == typeof a
    }

    function pa() {
        if (null === qa) a:{
            var a = p.document;
            if ((a = a.querySelector && a.querySelector("script[nonce]")) && (a = a.nonce || a.getAttribute("nonce")) && ra.test(a)) {
                qa = a;
                break a
            }
            qa = ""
        }
        return qa
    }

    var ra = /^[\w+/_-]+[=]{0,2}$/, qa = null;

    function sa() {
    }

    function ta(a) {
        a.Y = void 0;
        a.u = function () {
            return a.Y ? a.Y : a.Y = new a
        }
    }

    function ua(a) {
        var b = typeof a;
        if ("object" == b) if (a) {
            if (a instanceof Array) return "array";
            if (a instanceof Object) return b;
            var c = Object.prototype.toString.call(a);
            if ("[object Window]" == c) return "object";
            if ("[object Array]" == c || "number" == typeof a.length && "undefined" != typeof a.splice && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("splice")) return "array";
            if ("[object Function]" == c || "undefined" != typeof a.call && "undefined" != typeof a.propertyIsEnumerable && !a.propertyIsEnumerable("call")) return "function"
        } else return "null"; else if ("function" == b && "undefined" == typeof a.call) return "object";
        return b
    }

    function va(a) {
        return null === a
    }

    function wa(a) {
        var b = typeof a;
        return "object" == b && null != a || "function" == b
    }

    function xa(a) {
        return a[ya] || (a[ya] = ++za)
    }

    var ya = "closure_uid_" + (1E9 * Math.random() >>> 0), za = 0;

    function Aa(a, b, c) {
        return a.call.apply(a.bind, arguments)
    }

    function Ba(a, b, c) {
        if (!a) throw Error();
        if (2 < arguments.length) {
            var d = Array.prototype.slice.call(arguments, 2);
            return function () {
                var e = Array.prototype.slice.call(arguments);
                Array.prototype.unshift.apply(e, d);
                return a.apply(b, e)
            }
        }
        return function () {
            return a.apply(b, arguments)
        }
    }

    function Ca(a, b, c) {
        Function.prototype.bind && -1 != Function.prototype.bind.toString().indexOf("native code") ? Ca = Aa : Ca = Ba;
        return Ca.apply(null, arguments)
    }

    function Da(a, b) {
        var c = Array.prototype.slice.call(arguments, 1);
        return function () {
            var d = c.slice();
            d.push.apply(d, arguments);
            return a.apply(this, d)
        }
    }

    function t(a, b) {
        function c() {
        }

        c.prototype = b.prototype;
        a.Wa = b.prototype;
        a.prototype = new c;
        a.prototype.constructor = a;
        a.Ya = function (d, e, f) {
            for (var g = Array(arguments.length - 2), h = 2; h < arguments.length; h++) g[h - 2] = arguments[h];
            return b.prototype[e].apply(d, g)
        }
    };var Ea = (new Date).getTime();

    function Fa(a, b) {
        for (var c = a.length, d = r(a) ? a.split("") : a, e = 0; e < c; e++) e in d && b.call(void 0, d[e], e, a)
    }

    function Ga(a, b) {
        for (var c = a.length, d = [], e = 0, f = r(a) ? a.split("") : a, g = 0; g < c; g++) if (g in f) {
            var h = f[g];
            b.call(void 0, h, g, a) && (d[e++] = h)
        }
        return d
    }

    function Ha(a, b) {
        for (var c = a.length, d = Array(c), e = r(a) ? a.split("") : a, f = 0; f < c; f++) f in e && (d[f] = b.call(void 0, e[f], f, a));
        return d
    }

    function Ia(a, b) {
        a:{
            for (var c = a.length, d = r(a) ? a.split("") : a, e = 0; e < c; e++) if (e in d && b.call(void 0, d[e], e, a)) {
                b = e;
                break a
            }
            b = -1
        }
        return 0 > b ? null : r(a) ? a.charAt(b) : a[b]
    }

    function Ja(a, b) {
        a:{
            for (var c = r(a) ? a.split("") : a, d = a.length - 1; 0 <= d; d--) if (d in c && b.call(void 0, c[d], d, a)) {
                b = d;
                break a
            }
            b = -1
        }
        return 0 > b ? null : r(a) ? a.charAt(b) : a[b]
    }

    function Ka(a, b) {
        a:if (r(a)) a = r(b) && 1 == b.length ? a.indexOf(b, 0) : -1; else {
            for (var c = 0; c < a.length; c++) if (c in a && a[c] === b) {
                a = c;
                break a
            }
            a = -1
        }
        return 0 <= a
    };

    function La() {
        return function () {
            return !va.apply(this, arguments)
        }
    }

    function Ma(a) {
        var b = !1, c;
        return function () {
            b || (c = a(), b = !0);
            return c
        }
    }

    function Na(a) {
        var b = a;
        return function () {
            if (b) {
                var c = b;
                b = null;
                c()
            }
        }
    };

    function Oa(a, b) {
        for (var c in a) if (b.call(void 0, a[c], c, a)) return !0;
        return !1
    }

    function Pa(a) {
        var b = [], c = 0, d;
        for (d in a) b[c++] = a[d];
        return b
    }

    function Qa(a, b) {
        return null !== a && b in a
    };

    function Ra() {
        this.a = "";
        this.h = Sa
    }

    Ra.prototype.g = !0;
    Ra.prototype.b = function () {
        return this.a.toString()
    };

    function Ta(a) {
        if (a instanceof Ra && a.constructor === Ra && a.h === Sa) return a.a;
        ua(a);
        return "type_error:TrustedResourceUrl"
    }

    var Sa = {};

    function Ua(a) {
        return /^[\s\xa0]*([\s\S]*?)[\s\xa0]*$/.exec(a)[1]
    }

    var Va = /&/g, Wa = /</g, Xa = />/g, Ya = /"/g, Za = /'/g, $a = /\x00/g;

    function ab(a, b) {
        return -1 != a.indexOf(b)
    }

    function bb(a, b) {
        var c = 0;
        a = Ua(String(a)).split(".");
        b = Ua(String(b)).split(".");
        for (var d = Math.max(a.length, b.length), e = 0; 0 == c && e < d; e++) {
            var f = a[e] || "", g = b[e] || "";
            do {
                f = /(\d*)(\D*)(.*)/.exec(f) || ["", "", "", ""];
                g = /(\d*)(\D*)(.*)/.exec(g) || ["", "", "", ""];
                if (0 == f[0].length && 0 == g[0].length) break;
                c = cb(0 == f[1].length ? 0 : parseInt(f[1], 10), 0 == g[1].length ? 0 : parseInt(g[1], 10)) || cb(0 == f[2].length, 0 == g[2].length) || cb(f[2], g[2]);
                f = f[3];
                g = g[3]
            } while (0 == c)
        }
        return c
    }

    function cb(a, b) {
        return a < b ? -1 : a > b ? 1 : 0
    };

    function db() {
        this.a = "";
        this.h = fb
    }

    db.prototype.g = !0;
    db.prototype.b = function () {
        return this.a.toString()
    };

    function gb(a) {
        if (a instanceof db && a.constructor === db && a.h === fb) return a.a;
        ua(a);
        return "type_error:SafeUrl"
    }

    var hb = /^(?:(?:https?|mailto|ftp):|[^:/?#]*(?:[/?#]|$))/i, fb = {};

    function ib(a) {
        var b = new db;
        b.a = a;
        return b
    }

    ib("about:blank");
    var jb;
    a:{
        var kb = p.navigator;
        if (kb) {
            var lb = kb.userAgent;
            if (lb) {
                jb = lb;
                break a
            }
        }
        jb = ""
    }

    function u(a) {
        return ab(jb, a)
    }

    function mb(a) {
        for (var b = /(\w[\w ]+)\/([^\s]+)\s*(?:\((.*?)\))?/g, c = [], d; d = b.exec(a);) c.push([d[1], d[2], d[3] || void 0]);
        return c
    };

    function nb() {
        return (u("Chrome") || u("CriOS")) && !u("Edge")
    }

    function ob() {
        function a(e) {
            e = Ia(e, d);
            return c[e] || ""
        }

        var b = jb;
        if (u("Trident") || u("MSIE")) return pb(b);
        b = mb(b);
        var c = {};
        Fa(b, function (e) {
            c[e[0]] = e[1]
        });
        var d = Da(Qa, c);
        return u("Opera") ? a(["Version", "Opera"]) : u("Edge") ? a(["Edge"]) : nb() ? a(["Chrome", "CriOS"]) : (b = b[2]) && b[1] || ""
    }

    function qb(a) {
        return 0 <= bb(ob(), a)
    }

    function pb(a) {
        var b = /rv: *([\d\.]*)/.exec(a);
        if (b && b[1]) return b[1];
        b = "";
        var c = /MSIE +([\d\.]+)/.exec(a);
        if (c && c[1]) if (a = /Trident\/(\d.\d)/.exec(a), "7.0" == c[1]) if (a && a[1]) switch (a[1]) {
            case "4.0":
                b = "8.0";
                break;
            case "5.0":
                b = "9.0";
                break;
            case "6.0":
                b = "10.0";
                break;
            case "7.0":
                b = "11.0"
        } else b = "7.0"; else b = c[1];
        return b
    };

    function rb(a, b) {
        a.src = Ta(b);
        (b = pa()) && a.setAttribute("nonce", b)
    };var sb = {
        "\x00": "\\0",
        "\b": "\\b",
        "\f": "\\f",
        "\n": "\\n",
        "\r": "\\r",
        "\t": "\\t",
        "\x0B": "\\x0B",
        '"': '\\"',
        "\\": "\\\\",
        "<": "<"
    }, tb = {"'": "\\'"};

    function ub(a) {
        return String(a).replace(/\-([a-z])/g, function (b, c) {
            return c.toUpperCase()
        })
    };

    function vb(a) {
        vb[" "](a);
        return a
    }

    vb[" "] = sa;

    function v() {
    }

    var wb = "function" == typeof Uint8Array;

    function x(a, b, c, d) {
        a.a = null;
        b || (b = []);
        a.G = void 0;
        a.h = -1;
        a.b = b;
        a:{
            if (b = a.b.length) {
                --b;
                var e = a.b[b];
                if (null !== e && "object" == typeof e && "array" != ua(e) && !(wb && e instanceof Uint8Array)) {
                    a.i = b - a.h;
                    a.g = e;
                    break a
                }
            }
            a.i = Number.MAX_VALUE
        }
        a.w = {};
        if (c) for (b = 0; b < c.length; b++) e = c[b], e < a.i ? (e += a.h, a.b[e] = a.b[e] || xb) : (yb(a), a.g[e] = a.g[e] || xb);
        if (d && d.length) for (b = 0; b < d.length; b++) zb(a, d[b])
    }

    var xb = [];

    function yb(a) {
        var b = a.i + a.h;
        a.b[b] || (a.g = a.b[b] = {})
    }

    function z(a, b) {
        if (b < a.i) {
            b += a.h;
            var c = a.b[b];
            return c === xb ? a.b[b] = [] : c
        }
        if (a.g) return c = a.g[b], c === xb ? a.g[b] = [] : c
    }

    function Ab(a, b) {
        a = z(a, b);
        return null == a ? a : !!a
    }

    function A(a, b, c) {
        a = z(a, b);
        return null == a ? c : a
    }

    function Bb(a, b) {
        a = Ab(a, b);
        return null == a ? !1 : a
    }

    function Cb(a, b) {
        a = z(a, b);
        a = null == a ? a : +a;
        return null == a ? 0 : a
    }

    function Db(a, b, c) {
        b < a.i ? a.b[b + a.h] = c : (yb(a), a.g[b] = c)
    }

    function zb(a, b) {
        for (var c, d, e = 0; e < b.length; e++) {
            var f = b[e], g = z(a, f);
            null != g && (c = f, d = g, Db(a, f, void 0))
        }
        return c ? (Db(a, c, d), c) : 0
    }

    function C(a, b, c) {
        a.a || (a.a = {});
        if (!a.a[c]) {
            var d = z(a, c);
            d && (a.a[c] = new b(d))
        }
        return a.a[c]
    }

    function D(a, b, c) {
        a.a || (a.a = {});
        if (!a.a[c]) {
            for (var d = z(a, c), e = [], f = 0; f < d.length; f++) e[f] = new b(d[f]);
            a.a[c] = e
        }
        b = a.a[c];
        b == xb && (b = a.a[c] = []);
        return b
    }

    function Eb(a) {
        if (a.a) for (var b in a.a) {
            var c = a.a[b];
            if ("array" == ua(c)) for (var d = 0; d < c.length; d++) c[d] && Eb(c[d]); else c && Eb(c)
        }
        return a.b
    };

    function Fb(a) {
        x(this, a, Gb, null)
    }

    t(Fb, v);

    function Hb(a) {
        x(this, a, null, null)
    }

    t(Hb, v);
    var Gb = [2, 3];
    var Ib = document, E = window;
    var Jb = {"120x90": !0, "160x90": !0, "180x90": !0, "200x90": !0, "468x15": !0, "728x15": !0};

    function Kb(a, b) {
        if (15 == b) {
            if (728 <= a) return 728;
            if (468 <= a) return 468
        } else if (90 == b) {
            if (200 <= a) return 200;
            if (180 <= a) return 180;
            if (160 <= a) return 160;
            if (120 <= a) return 120
        }
        return null
    };

    function Lb(a) {
        this.a = a || p.document || document
    }

    function Mb(a, b) {
        return a.a.createElement(String(b))
    }

    Lb.prototype.contains = function (a, b) {
        if (!a || !b) return !1;
        if (a.contains && 1 == b.nodeType) return a == b || a.contains(b);
        if ("undefined" != typeof a.compareDocumentPosition) return a == b || !!(a.compareDocumentPosition(b) & 16);
        for (; b && a != b;) b = b.parentNode;
        return b == a
    };

    function Nb(a) {
        Ob();
        var b = new Ra;
        b.a = a;
        return b
    }

    var Ob = sa;

    function Pb() {
        return !(u("iPad") || u("Android") && !u("Mobile") || u("Silk")) && (u("iPod") || u("iPhone") || u("Android") || u("IEMobile"))
    };

    function Qb(a) {
        try {
            var b;
            if (b = !!a && null != a.location.href) a:{
                try {
                    vb(a.foo);
                    b = !0;
                    break a
                } catch (c) {
                }
                b = !1
            }
            return b
        } catch (c) {
            return !1
        }
    }

    function Rb(a) {
        for (var b = p, c = 0; b && 40 > c++ && (!Qb(b) || !a(b));) b = Sb(b)
    }

    function Tb() {
        var a = p;
        Rb(function (b) {
            a = b;
            return !1
        });
        return a
    }

    function Sb(a) {
        try {
            var b = a.parent;
            if (b && b != a) return b
        } catch (c) {
        }
        return null
    }

    function Ub(a, b) {
        var c = [p.top], d = [], e = 0;
        b = b || 1024;
        for (var f; f = c[e++];) {
            a && !Qb(f) || d.push(f);
            try {
                if (f.frames) for (var g = f.frames.length, h = 0; h < g && c.length < b; ++h) c.push(f.frames[h])
            } catch (k) {
            }
        }
        return d
    }

    function Vb(a, b) {
        var c = a.createElement("script");
        rb(c, Nb(b));
        return (a = a.getElementsByTagName("script")[0]) && a.parentNode ? (a.parentNode.insertBefore(c, a), c) : null
    }

    function Wb(a, b) {
        return b.getComputedStyle ? b.getComputedStyle(a, null) : a.currentStyle
    }

    function Xb(a, b, c) {
        var d = !1;
        void 0 === c || c || (d = Yb());
        return !d && !Zb() && (c = Math.random(), c < b) ? (c = $b(p), a[Math.floor(c * a.length)]) : null
    }

    function $b(a) {
        if (!a.crypto) return Math.random();
        try {
            var b = new Uint32Array(1);
            a.crypto.getRandomValues(b);
            return b[0] / 65536 / 65536
        } catch (c) {
            return Math.random()
        }
    }

    function ac(a, b) {
        if (a) for (var c in a) Object.prototype.hasOwnProperty.call(a, c) && b.call(void 0, a[c], c, a)
    }

    function bc(a) {
        var b = a.length;
        if (0 == b) return 0;
        for (var c = 305419896, d = 0; d < b; d++) c ^= (c << 5) + (c >> 2) + a.charCodeAt(d) & 4294967295;
        return 0 < c ? c : 4294967296 + c
    }

    var Zb = Ma(function () {
        return ab(jb, "Google Web Preview") || 1E-4 > Math.random()
    }), Yb = Ma(function () {
        return ab(jb, "MSIE")
    }), cc = /^([0-9.]+)px$/, dc = /^(-?[0-9.]{1,30})$/;

    function ec(a) {
        return dc.test(a) && (a = Number(a), !isNaN(a)) ? a : null
    }

    function fc(a, b) {
        return b ? !/^false$/.test(a) : /^true$/.test(a)
    }

    function F(a) {
        return (a = cc.exec(a)) ? +a[1] : null
    }

    function gc(a, b) {
        try {
            return !(!a.frames || !a.frames[b])
        } catch (c) {
            return !1
        }
    }

    function hc(a) {
        var b = {display: "none"};
        a.style.setProperty ? ac(b, function (c, d) {
            a.style.setProperty(d, c, "important")
        }) : a.style.cssText = ic(jc(kc(a.style.cssText), lc(b, function (c) {
            return c + " !important"
        })))
    }

    var jc = Object.assign || function (a, b) {
        for (var c = 1; c < arguments.length; c++) {
            var d = arguments[c];
            if (d) for (var e in d) Object.prototype.hasOwnProperty.call(d, e) && (a[e] = d[e])
        }
        return a
    };

    function lc(a, b) {
        var c = {}, d;
        for (d in a) Object.prototype.hasOwnProperty.call(a, d) && (c[d] = b.call(void 0, a[d], d, a));
        return c
    }

    function ic(a) {
        var b = [];
        ac(a, function (c, d) {
            null != c && "" !== c && b.push(d + ":" + c)
        });
        return b.length ? b.join(";") + ";" : ""
    }

    function kc(a) {
        var b = {};
        if (a) {
            var c = /\s*:\s*/;
            Fa((a || "").split(/\s*;\s*/), function (d) {
                if (d) {
                    var e = d.split(c);
                    d = e[0];
                    e = e[1];
                    d && e && (b[d.toLowerCase()] = e)
                }
            })
        }
        return b
    };

    function mc(a, b, c) {
        a.addEventListener && a.addEventListener(b, c, !1)
    };

    function nc(a, b) {
        p.google_image_requests || (p.google_image_requests = []);
        var c = p.document.createElement("img");
        if (b) {
            var d = function (e) {
                b && b(e);
                c.removeEventListener && c.removeEventListener("load", d, !1);
                c.removeEventListener && c.removeEventListener("error", d, !1)
            };
            mc(c, "load", d);
            mc(c, "error", d)
        }
        c.src = a;
        p.google_image_requests.push(c)
    };

    function oc(a, b) {
        a = parseInt(a, 10);
        return isNaN(a) ? b : a
    }

    var pc = /^([\w-]+\.)*([\w-]{2,})(:[0-9]+)?$/;

    function qc(a, b) {
        return a ? (a = a.match(pc)) ? a[0] : b : b
    };

    function rc() {
        return "r20190513"
    }

    var sc = fc("false", !1), tc = fc("true", !1), uc = fc("true", !1), vc = uc || !tc, wc;
    var xc = [null, null];
    try {
        wc = JSON.parse("[null,[[null,[[null,[[21062754],[21062755]]]]],[5,[[1,[[21062810],[21062811]]],[1,[[21063251],[21063252,[[147,null,null,[1]]]]]]]]]]")
    } catch (a) {
        wc = xc
    }
    var yc = wc;

    function zc() {
        return qc("", "pagead2.googlesyndication.com")
    };

    function Ac(a) {
        a = void 0 === a ? p : a;
        var b = a.context || a.AMP_CONTEXT_DATA;
        if (!b) try {
            b = a.parent.context || a.parent.AMP_CONTEXT_DATA
        } catch (c) {
        }
        try {
            if (b && b.pageViewId && b.canonicalUrl) return b
        } catch (c) {
        }
        return null
    }

    function Bc(a) {
        return (a = a || Ac()) ? Qb(a.master) ? a.master : null : null
    };

    function Cc(a, b) {
        for (var c in a) Object.prototype.hasOwnProperty.call(a, c) && b.call(void 0, a[c], c, a)
    }

    function Dc(a) {
        return !(!a || !a.call) && "function" === typeof a
    }

    function Ec(a) {
        a = Bc(Ac(a)) || a;
        a.google_unique_id ? ++a.google_unique_id : a.google_unique_id = 1
    }

    function Fc(a) {
        a = Bc(Ac(a)) || a;
        a = a.google_unique_id;
        return "number" === typeof a ? a : 0
    }

    var Gc = !!window.google_async_iframe_id, Hc = Gc && window.parent || window;

    function Ic() {
        if (Gc && !Qb(Hc)) {
            var a = "." + Ib.domain;
            try {
                for (; 2 < a.split(".").length && !Qb(Hc);) Ib.domain = a = a.substr(a.indexOf(".") + 1), Hc = window.parent
            } catch (b) {
            }
            Qb(Hc) || (Hc = window)
        }
        return Hc
    }

    var Jc = /(^| )adsbygoogle($| )/;

    function Kc(a) {
        return sc && a.google_top_window || a.top
    }

    function Lc(a) {
        a = Kc(a);
        return Qb(a) ? a : null
    };

    function H(a) {
        a.google_ad_modifications || (a.google_ad_modifications = {});
        return a.google_ad_modifications
    }

    function I(a, b) {
        a:if (a = H(a).eids || [], a.indexOf) b = a.indexOf(b), b = 0 < b || 0 === b; else {
            for (var c = 0; c < a.length; c++) if (a[c] === b) {
                b = !0;
                break a
            }
            b = !1
        }
        return b
    }

    function Mc(a, b) {
        a = H(a);
        a.tag_partners = a.tag_partners || [];
        a.tag_partners.push(b)
    }

    function Nc(a, b, c) {
        for (var d = 0; d < a.length; ++d) if ((a[d].ad_slot || b) == b && (a[d].ad_tag_origin || c) == c) return a[d];
        return null
    };var Oc = {overlays: 1, interstitials: 2, vignettes: 2, inserts: 3, immersives: 4, list_view: 5, full_page: 6};

    function K(a) {
        x(this, a, Pc, null)
    }

    t(K, v);

    function Qc(a) {
        x(this, a, null, null)
    }

    t(Qc, v);

    function Rc(a) {
        x(this, a, null, null)
    }

    t(Rc, v);

    function L(a) {
        x(this, a, null, null)
    }

    t(L, v);

    function Sc(a) {
        x(this, a, Tc, null)
    }

    t(Sc, v);
    var Pc = [4];
    K.prototype.N = function () {
        return z(this, 3)
    };
    var Tc = [6, 7, 9, 10, 11];

    function Uc(a) {
        x(this, a, null, Vc)
    }

    t(Uc, v);

    function Wc(a) {
        x(this, a, null, null)
    }

    t(Wc, v);

    function Xc(a) {
        x(this, a, null, null)
    }

    t(Xc, v);

    function Yc(a) {
        x(this, a, null, null)
    }

    t(Yc, v);

    function $c(a) {
        x(this, a, ad, null)
    }

    t($c, v);

    function bd(a) {
        x(this, a, null, null)
    }

    t(bd, v);

    function cd(a) {
        x(this, a, dd, null)
    }

    t(cd, v);

    function ed(a) {
        x(this, a, null, null)
    }

    t(ed, v);

    function fd(a) {
        x(this, a, null, null)
    }

    t(fd, v);
    var Vc = [[1, 2, 3]], ad = [1, 2, 5, 7], dd = [2, 5, 6];

    function gd(a, b) {
        a = a.replace(/(^\/)|(\/$)/g, "");
        var c = bc(a), d = hd(a);
        return b.find(function (e) {
            var f = null != z(e, 7) ? z(C(e, ed, 7), 1) : z(e, 1);
            e = null != z(e, 7) ? z(C(e, ed, 7), 2) : 2;
            if (!oa(f)) return !1;
            switch (e) {
                case 1:
                    return f == c;
                case 2:
                    return d[f] || !1
            }
            return !1
        }) || null
    }

    function hd(a) {
        for (var b = {}; ;) {
            b[bc(a)] = !0;
            if (!a) return b;
            a = a.substring(0, a.lastIndexOf("/"))
        }
    };

    function id(a, b) {
        var c = void 0 === c ? {} : c;
        this.error = a;
        this.context = b.context;
        this.msg = b.message || "";
        this.id = b.id || "jserror";
        this.meta = c
    };var jd = /^https?:\/\/(\w|-)+\.cdn\.ampproject\.(net|org)(\?|\/|$)/;

    function kd(a, b) {
        this.a = a;
        this.b = b
    }

    function ld(a, b, c) {
        this.url = a;
        this.a = b;
        this.ma = !!c;
        this.depth = oa(void 0) ? void 0 : null
    };

    function md() {
        this.g = "&";
        this.h = !1;
        this.b = {};
        this.i = 0;
        this.a = []
    }

    function nd(a, b) {
        var c = {};
        c[a] = b;
        return [c]
    }

    function od(a, b, c, d, e) {
        var f = [];
        ac(a, function (g, h) {
            (g = pd(g, b, c, d, e)) && f.push(h + "=" + g)
        });
        return f.join(b)
    }

    function pd(a, b, c, d, e) {
        if (null == a) return "";
        b = b || "&";
        c = c || ",$";
        "string" == typeof c && (c = c.split(""));
        if (a instanceof Array) {
            if (d = d || 0, d < c.length) {
                for (var f = [], g = 0; g < a.length; g++) f.push(pd(a[g], b, c, d + 1, e));
                return f.join(c[d])
            }
        } else if ("object" == typeof a) return e = e || 0, 2 > e ? encodeURIComponent(od(a, b, c, d, e + 1)) : "...";
        return encodeURIComponent(String(a))
    }

    function qd(a, b, c, d) {
        a.a.push(b);
        a.b[b] = nd(c, d)
    }

    function rd(a, b, c) {
        b = b + "//pagead2.googlesyndication.com" + c;
        var d = sd(a) - c.length;
        if (0 > d) return "";
        a.a.sort(function (n, q) {
            return n - q
        });
        c = null;
        for (var e = "", f = 0; f < a.a.length; f++) for (var g = a.a[f], h = a.b[g], k = 0; k < h.length; k++) {
            if (!d) {
                c = null == c ? g : c;
                break
            }
            var m = od(h[k], a.g, ",$");
            if (m) {
                m = e + m;
                if (d >= m.length) {
                    d -= m.length;
                    b += m;
                    e = a.g;
                    break
                } else a.h && (e = d, m[e - 1] == a.g && --e, b += m.substr(0, e), e = a.g, d = 0);
                c = null == c ? g : c
            }
        }
        a = "";
        null != c && (a = e + "trn=" + c);
        return b + a
    }

    function sd(a) {
        var b = 1, c;
        for (c in a.b) b = c.length > b ? c.length : b;
        return 3997 - b - a.g.length - 1
    };

    function td(a, b, c, d, e, f) {
        if ((d ? a.b : Math.random()) < (e || .01)) try {
            if (c instanceof md) var g = c; else g = new md, ac(c, function (k, m) {
                var n = g, q = n.i++;
                k = nd(m, k);
                n.a.push(q);
                n.b[q] = k
            });
            var h = rd(g, a.a, "/pagead/gen_204?id=" + b + "&");
            h && ("undefined" === typeof f ? nc(h, null) : nc(h, void 0 === f ? null : f))
        } catch (k) {
        }
    };

    function ud(a, b) {
        this.start = a < b ? a : b;
        this.a = a < b ? b : a
    };

    function M(a, b, c) {
        this.b = b >= a ? new ud(a, b) : null;
        this.a = c
    }

    function vd(a, b) {
        var c = -1;
        b = "google_experiment_mod" + (void 0 === b ? "" : b);
        try {
            a.localStorage && (c = parseInt(a.localStorage.getItem(b), 10))
        } catch (d) {
            return null
        }
        if (0 <= c && 1E3 > c) return c;
        if (Zb()) return null;
        c = Math.floor(1E3 * $b(a));
        try {
            if (a.localStorage) return a.localStorage.setItem(b, "" + c), c
        } catch (d) {
        }
        return null
    };var wd = null;

    function xd() {
        if (null === wd) {
            wd = "";
            try {
                var a = "";
                try {
                    a = p.top.location.hash
                } catch (c) {
                    a = p.location.hash
                }
                if (a) {
                    var b = a.match(/\bdeid=([\d,]+)/);
                    wd = b ? b[1] : ""
                }
            } catch (c) {
            }
        }
        return wd
    };

    function yd() {
        var a = p.performance;
        return a && a.now && a.timing ? Math.floor(a.now() + a.timing.navigationStart) : +new Date
    }

    function zd() {
        var a = void 0 === a ? p : a;
        return (a = a.performance) && a.now ? a.now() : null
    };

    function Ad(a, b, c) {
        this.label = a;
        this.type = b;
        this.value = c;
        this.duration = 0;
        this.uniqueId = Math.random();
        this.slotId = void 0
    };var Bd = p.performance, Cd = !!(Bd && Bd.mark && Bd.measure && Bd.clearMarks), Dd = Ma(function () {
        var a;
        if (a = Cd) a = xd(), a = !!a.indexOf && 0 <= a.indexOf("1337");
        return a
    });

    function Ed() {
        var a = Fd;
        this.b = [];
        this.g = a || p;
        var b = null;
        a && (a.google_js_reporting_queue = a.google_js_reporting_queue || [], this.b = a.google_js_reporting_queue, b = a.google_measure_js_timing);
        this.a = Dd() || (null != b ? b : 1 > Math.random())
    }

    function Gd(a) {
        a && Bd && Dd() && (Bd.clearMarks("goog_" + a.label + "_" + a.uniqueId + "_start"), Bd.clearMarks("goog_" + a.label + "_" + a.uniqueId + "_end"))
    }

    Ed.prototype.start = function (a, b) {
        if (!this.a) return null;
        var c = zd() || yd();
        a = new Ad(a, b, c);
        b = "goog_" + a.label + "_" + a.uniqueId + "_start";
        Bd && Dd() && Bd.mark(b);
        return a
    };

    function Hd() {
        var a = Id;
        this.G = Jd;
        this.h = !0;
        this.g = null;
        this.w = this.a;
        this.b = void 0 === a ? null : a;
        this.i = !1
    }

    function Kd(a, b, c, d) {
        try {
            if (a.b && a.b.a) {
                var e = a.b.start(b.toString(), 3);
                var f = c();
                var g = a.b;
                c = e;
                if (g.a && oa(c.value)) {
                    var h = zd() || yd();
                    c.duration = h - c.value;
                    var k = "goog_" + c.label + "_" + c.uniqueId + "_end";
                    Bd && Dd() && Bd.mark(k);
                    !g.a || 2048 < g.b.length || g.b.push(c)
                }
            } else f = c()
        } catch (m) {
            g = a.h;
            try {
                Gd(e), g = a.w(b, new id(m, {message: Ld(m)}), void 0, d)
            } catch (n) {
                a.a(217, n)
            }
            if (!g) throw m;
        }
        return f
    }

    function Md(a, b) {
        var c = Nd;
        return function (d) {
            for (var e = [], f = 0; f < arguments.length; ++f) e[f] = arguments[f];
            return Kd(c, a, function () {
                return b.apply(void 0, e)
            }, void 0)
        }
    }

    Hd.prototype.a = function (a, b, c, d, e) {
        e = e || "jserror";
        try {
            var f = new md;
            f.h = !0;
            qd(f, 1, "context", a);
            b.error && b.meta && b.id || (b = new id(b, {message: Ld(b)}));
            b.msg && qd(f, 2, "msg", b.msg.substring(0, 512));
            var g = b.meta || {};
            if (this.g) try {
                this.g(g)
            } catch (J) {
            }
            if (d) try {
                d(g)
            } catch (J) {
            }
            b = [g];
            f.a.push(3);
            f.b[3] = b;
            d = p;
            b = [];
            g = null;
            do {
                var h = d;
                if (Qb(h)) {
                    var k = h.location.href;
                    g = h.document && h.document.referrer || null
                } else k = g, g = null;
                b.push(new ld(k || "", h));
                try {
                    d = h.parent
                } catch (J) {
                    d = null
                }
            } while (d && h != d);
            k = 0;
            for (var m = b.length - 1; k <= m; ++k) b[k].depth = m - k;
            h = p;
            if (h.location && h.location.ancestorOrigins && h.location.ancestorOrigins.length == b.length - 1) for (m = 1; m < b.length; ++m) {
                var n = b[m];
                n.url || (n.url = h.location.ancestorOrigins[m - 1] || "", n.ma = !0)
            }
            var q = new ld(p.location.href, p, !1);
            h = null;
            var w = b.length - 1;
            for (n = w; 0 <= n; --n) {
                var y = b[n];
                !h && jd.test(y.url) && (h = y);
                if (y.url && !y.ma) {
                    q = y;
                    break
                }
            }
            y = null;
            var G = b.length && b[w].url;
            0 != q.depth && G && (y = b[w]);
            var B = new kd(q, y);
            B.b && qd(f, 4, "top", B.b.url || "");
            qd(f, 5, "url", B.a.url || "");
            td(this.G, e, f, this.i, c)
        } catch (J) {
            try {
                td(this.G, e, {context: "ecmserr", rctx: a, msg: Ld(J), url: B && B.a.url}, this.i, c)
            } catch (eb) {
            }
        }
        return this.h
    };

    function Ld(a) {
        var b = a.toString();
        a.name && -1 == b.indexOf(a.name) && (b += ": " + a.name);
        a.message && -1 == b.indexOf(a.message) && (b += ": " + a.message);
        if (a.stack) {
            a = a.stack;
            var c = b;
            try {
                -1 == a.indexOf(c) && (a = c + "\n" + a);
                for (var d; a != d;) d = a, a = a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/, "$1");
                b = a.replace(/\n */g, "\n")
            } catch (e) {
                b = c
            }
        }
        return b
    };

    function N(a) {
        a = void 0 === a ? "" : a;
        var b = Error.call(this);
        this.message = b.message;
        "stack" in b && (this.stack = b.stack);
        this.name = "TagError";
        this.message = a ? "adsbygoogle.push() error: " + a : "";
        Error.captureStackTrace ? Error.captureStackTrace(this, N) : this.stack = Error().stack || ""
    }

    ja(N, Error);
    var Jd, Nd, Fd = Ic(), Id = new Ed;

    function Od(a) {
        null != a && (Fd.google_measure_js_timing = a);
        Fd.google_measure_js_timing || (a = Id, a.a = !1, a.b != a.g.google_js_reporting_queue && (Dd() && Fa(a.b, Gd), a.b.length = 0))
    }

    Jd = new function () {
        var a = void 0 === a ? E : a;
        this.a = "http:" === a.location.protocol ? "http:" : "https:";
        this.b = Math.random()
    };
    Nd = new Hd;
    "complete" == Fd.document.readyState ? Od() : Id.a && mc(Fd, "load", function () {
        Od()
    });

    function Pd() {
        var a = [Qd, Rd];
        Nd.g = function (b) {
            Fa(a, function (c) {
                c(b)
            })
        }
    }

    function Sd(a, b, c) {
        return Kd(Nd, a, b, c)
    }

    function Td(a, b) {
        return Md(a, b)
    }

    function Ud(a, b, c) {
        td(Jd, a, b, "jserror" != a, c, void 0)
    }

    function Vd(a, b, c, d) {
        return 0 == (b.error && b.meta && b.id ? b.msg || Ld(b.error) : Ld(b)).indexOf("TagError") ? (Nd.i = !0, c = b instanceof id ? b.error : b, c.pbr || (c.pbr = !0, Nd.a(a, b, .1, d, "puberror")), !1) : Nd.a(a, b, c, d)
    }

    function Wd(a) {
        Ud("rmvasft", {code: "ldr", branch: a ? "exp" : "cntr"})
    };

    function Xd(a, b) {
        this.ja = a;
        this.ra = b
    }

    function Yd(a) {
        var b = [].slice.call(arguments).filter(La());
        if (!b.length) return null;
        var c = [], d = {};
        b.forEach(function (e) {
            c = c.concat(e.ja || []);
            d = Object.assign(d, e.ra)
        });
        return new Xd(c, d)
    }

    function Zd(a) {
        switch (a) {
            case 1:
                return new Xd(null, {google_ad_semantic_area: "mc"});
            case 2:
                return new Xd(null, {google_ad_semantic_area: "h"});
            case 3:
                return new Xd(null, {google_ad_semantic_area: "f"});
            case 4:
                return new Xd(null, {google_ad_semantic_area: "s"});
            default:
                return null
        }
    };var $d = new Xd(["google-auto-placed"], {google_tag_origin: "qs"});
    var ae = {}, be = (ae.google_ad_channel = !0, ae.google_ad_host = !0, ae);

    function ce(a, b) {
        a.location.href && a.location.href.substring && (b.url = a.location.href.substring(0, 200));
        Ud("ama", b, .01)
    }

    function de(a) {
        var b = {};
        ac(be, function (c, d) {
            d in a && (b[d] = a[d])
        });
        return b
    };

    function ee(a, b, c) {
        c || (c = vc ? "https" : "http");
        p.location && "https:" == p.location.protocol && "http" == c && (c = "https");
        return [c, "://", a, b].join("")
    };var fe = null;

    function ge() {
        if (!sc) return !1;
        if (null != fe) return fe;
        fe = !1;
        try {
            var a = Lc(p);
            a && -1 != a.location.hash.indexOf("google_logging") && (fe = !0);
            p.localStorage.getItem("google_logging") && (fe = !0)
        } catch (b) {
        }
        return fe
    }

    function he(a, b) {
        b = void 0 === b ? [] : b;
        var c = !1;
        p.google_logging_queue || (c = !0, p.google_logging_queue = []);
        p.google_logging_queue.push([a, b]);
        c && ge() && (a = ee(zc(), "/pagead/js/logging_library.js"), Vb(p.document, a))
    };

    function ie(a) {
        x(this, a, null, null)
    }

    t(ie, v);
    var je = {rectangle: 1, horizontal: 2, vertical: 4};

    function ke() {
        this.wasPlaTagProcessed = !1;
        this.wasReactiveAdConfigReceived = {};
        this.adCount = {};
        this.wasReactiveAdVisible = {};
        this.stateForType = {};
        this.reactiveTypeEnabledInAsfe = {};
        this.isReactiveTagFirstOnPage = this.wasReactiveAdConfigHandlerRegistered = this.wasReactiveTagRequestSent = !1;
        this.reactiveTypeDisabledByPublisher = {};
        this.tagSpecificState = {};
        this.adRegion = this.floatingAdsFillMessage = null;
        this.improveCollisionDetection = 0;
        this.messageValidationEnabled = !1
    }

    function le(a) {
        a.google_reactive_ads_global_state || (a.google_reactive_ads_global_state = new ke);
        return a.google_reactive_ads_global_state
    };

    function me(a) {
        a = a.document;
        var b = {};
        a && (b = "CSS1Compat" == a.compatMode ? a.documentElement : a.body);
        return b || {}
    }

    function O(a) {
        return me(a).clientWidth
    };

    function ne(a, b) {
        for (var c = ["width", "height"], d = 0; d < c.length; d++) {
            var e = "google_ad_" + c[d];
            if (!b.hasOwnProperty(e)) {
                var f = F(a[c[d]]);
                f = null === f ? null : Math.round(f);
                null != f && (b[e] = f)
            }
        }
    }

    function oe(a, b) {
        return !((dc.test(b.google_ad_width) || cc.test(a.style.width)) && (dc.test(b.google_ad_height) || cc.test(a.style.height)))
    }

    function pe(a, b) {
        try {
            var c = b.document.documentElement.getBoundingClientRect(), d = a.getBoundingClientRect();
            var e = {x: d.left - c.left, y: d.top - c.top}
        } catch (f) {
            e = null
        }
        return (a = e) ? a.y : 0
    }

    function qe(a, b) {
        do {
            var c = Wb(a, b);
            if (c && "fixed" == c.position) return !1
        } while (a = a.parentElement);
        return !0
    }

    function re(a) {
        var b = 0, c;
        for (c in je) -1 != a.indexOf(c) && (b |= je[c]);
        return b
    }

    function se(a, b, c, d, e) {
        if (Kc(a) != a) return Lc(a) ? 3 : 16;
        if (!(488 > O(a))) return 4;
        if (!(a.innerHeight >= a.innerWidth)) return 5;
        var f = O(a);
        if (!f || (f - c) / f > d) a = 6; else {
            if (c = "true" != e.google_full_width_responsive) a:{
                c = O(a);
                for (b = b.parentElement; b; b = b.parentElement) if ((d = Wb(b, a)) && (e = F(d.width)) && !(e >= c) && "visible" != d.overflow) {
                    c = !0;
                    break a
                }
                c = !1
            }
            a = c ? 7 : !0
        }
        return a
    }

    function te(a, b, c, d) {
        var e = se(b, c, a, .3, d);
        if (!0 !== e) return e;
        e = O(b);
        a = e - a;
        a = e && 0 <= a ? !0 : e ? -10 > a ? 11 : 0 > a ? 14 : 12 : 10;
        return "true" == d.google_full_width_responsive || qe(c, b) ? a : 9
    }

    function ue(a, b) {
        if (3 == b.nodeType) return /\S/.test(b.data);
        if (1 == b.nodeType) {
            if (/^(script|style)$/i.test(b.nodeName)) return !1;
            try {
                var c = Wb(b, a)
            } catch (d) {
            }
            return !c || "none" != c.display && !("absolute" == c.position && ("hidden" == c.visibility || "collapse" == c.visibility))
        }
        return !1
    }

    function ve(a, b, c, d, e, f) {
        if (a = Wb(c, a)) {
            var g = F(a.paddingLeft) || 0;
            a = a.direction;
            d = e - d;
            if (f.google_ad_resize) g = -1 * (d + g) + "px"; else {
                for (var h = f = 0; 100 > h && c; h++) f += c.offsetLeft + c.clientLeft - c.scrollLeft, c = c.offsetParent;
                g = f + g;
                g = "rtl" == a ? -1 * (d - g) + "px" : -1 * g + "px"
            }
            "rtl" == a ? b.style.marginRight = g : b.style.marginLeft = g;
            b.style.width = e + "px";
            b.style.zIndex = 30
        }
    };

    function P(a, b) {
        this.b = a;
        this.a = b
    }

    l = P.prototype;
    l.minWidth = function () {
        return this.b
    };
    l.height = function () {
        return this.a
    };
    l.I = function (a) {
        return 300 < a && 300 < this.a ? this.b : Math.min(1200, Math.round(a))
    };
    l.W = function (a) {
        return this.I(a) + "x" + this.height()
    };
    l.P = function () {
    };

    function we(a, b, c, d) {
        d = void 0 === d ? function (f) {
            return f
        } : d;
        var e;
        return a.style && a.style[c] && d(a.style[c]) || (e = Wb(a, b)) && e[c] && d(e[c]) || null
    }

    function xe(a) {
        return function (b) {
            return b.minWidth() <= a
        }
    }

    function ye(a, b, c, d) {
        var e = a && ze(c, b), f = Ae(b, d);
        return function (g) {
            return !(e && g.height() >= f)
        }
    }

    function Be(a) {
        return function (b) {
            return b.height() <= a
        }
    }

    function ze(a, b) {
        return pe(a, b) < me(b).clientHeight - 100
    }

    function Ce(a, b) {
        var c = Infinity;
        do {
            var d = we(b, a, "height", F);
            d && (c = Math.min(c, d));
            (d = we(b, a, "maxHeight", F)) && (c = Math.min(c, d))
        } while ((b = b.parentElement) && "HTML" != b.tagName);
        return c
    }

    function De(a, b) {
        var c = we(b, a, "height", F);
        if (c) return c;
        var d = b.style.height;
        b.style.height = "inherit";
        c = we(b, a, "height", F);
        b.style.height = d;
        if (c) return c;
        c = Infinity;
        do (d = b.style && F(b.style.height)) && (c = Math.min(c, d)), (d = we(b, a, "maxHeight", F)) && (c = Math.min(c, d)); while ((b = b.parentElement) && "HTML" != b.tagName);
        return c
    }

    function Ae(a, b) {
        var c = a.google_unique_id;
        return b && 0 == ("number" === typeof c ? c : 0) ? Math.max(250, 2 * me(a).clientHeight / 3) : 250
    };

    function Ee(a, b) {
        for (var c = [], d = a.length, e = 0; e < d; e++) c.push(a[e]);
        c.forEach(b, void 0)
    };

    function Fe(a) {
        if (1 != a.nodeType) var b = !1; else if (b = "INS" == a.tagName) a:{
            b = ["adsbygoogle-placeholder"];
            a = a.className ? a.className.split(/\s+/) : [];
            for (var c = {}, d = 0; d < a.length; ++d) c[a[d]] = !0;
            for (d = 0; d < b.length; ++d) if (!c[b[d]]) {
                b = !1;
                break a
            }
            b = !0
        }
        return b
    };

    function Ge(a, b) {
        for (var c = 0; c < b.length; c++) {
            var d = b[c], e = ub(d.Za);
            a[e] = d.value
        }
    };var He = null;

    function Ie() {
        if (!He) {
            for (var a = p, b = a, c = 0; a && a != a.parent;) if (a = a.parent, c++, Qb(a)) b = a; else break;
            He = b
        }
        return He
    };

    function Je(a, b, c, d) {
        this.h = a;
        this.b = b;
        this.g = c;
        this.a = d
    }

    function Ke(a, b) {
        var c = [];
        try {
            c = b.querySelectorAll(a.h)
        } catch (g) {
        }
        if (!c.length) return [];
        b = c;
        c = b.length;
        if (0 < c) {
            for (var d = Array(c), e = 0; e < c; e++) d[e] = b[e];
            b = d
        } else b = [];
        b = Le(a, b);
        oa(a.b) && (c = a.b, 0 > c && (c += b.length), b = 0 <= c && c < b.length ? [b[c]] : []);
        if (oa(a.g)) {
            c = [];
            for (d = 0; d < b.length; d++) {
                e = Me(b[d]);
                var f = a.g;
                0 > f && (f += e.length);
                0 <= f && f < e.length && c.push(e[f])
            }
            b = c
        }
        return b
    }

    Je.prototype.toString = function () {
        return JSON.stringify({
            nativeQuery: this.h,
            occurrenceIndex: this.b,
            paragraphIndex: this.g,
            ignoreMode: this.a
        })
    };

    function Le(a, b) {
        if (null == a.a) return b;
        switch (a.a) {
            case 1:
                return b.slice(1);
            case 2:
                return b.slice(0, b.length - 1);
            case 3:
                return b.slice(1, b.length - 1);
            case 0:
                return b;
            default:
                throw Error("Unknown ignore mode: " + a.a);
        }
    }

    function Me(a) {
        var b = [];
        Ee(a.getElementsByTagName("p"), function (c) {
            100 <= Ne(c) && b.push(c)
        });
        return b
    }

    function Ne(a) {
        if (3 == a.nodeType) return a.length;
        if (1 != a.nodeType || "SCRIPT" == a.tagName) return 0;
        var b = 0;
        Ee(a.childNodes, function (c) {
            b += Ne(c)
        });
        return b
    }

    function Oe(a) {
        return 0 == a.length || isNaN(a[0]) ? a : "\\" + (30 + parseInt(a[0], 10)) + " " + a.substring(1)
    };

    function Pe(a) {
        if (!a) return null;
        var b = z(a, 7);
        if (z(a, 1) || a.N() || 0 < z(a, 4).length) {
            var c = a.N(), d = z(a, 1), e = z(a, 4);
            b = z(a, 2);
            var f = z(a, 5);
            a = Qe(z(a, 6));
            var g = "";
            d && (g += d);
            c && (g += "#" + Oe(c));
            if (e) for (c = 0; c < e.length; c++) g += "." + Oe(e[c]);
            b = (e = g) ? new Je(e, b, f, a) : null
        } else b = b ? new Je(b, z(a, 2), z(a, 5), Qe(z(a, 6))) : null;
        return b
    }

    var Re = {1: 1, 2: 2, 3: 3, 0: 0};

    function Qe(a) {
        return null != a ? Re[a] : a
    }

    var Se = {1: 0, 2: 1, 3: 2, 4: 3};

    function Te(a, b) {
        function c() {
            d.push({anchor: e.anchor, position: e.position});
            return e.anchor == b.anchor && e.position == b.position
        }

        for (var d = [], e = a; e;) {
            switch (e.position) {
                case 1:
                    if (c()) return d;
                    e.position = 2;
                case 2:
                    if (c()) return d;
                    if (e.anchor.firstChild) {
                        e = {anchor: e.anchor.firstChild, position: 1};
                        continue
                    } else e.position = 3;
                case 3:
                    if (c()) return d;
                    e.position = 4;
                case 4:
                    if (c()) return d
            }
            for (; e && !e.anchor.nextSibling && e.anchor.parentNode != e.anchor.ownerDocument.body;) {
                e = {anchor: e.anchor.parentNode, position: 3};
                if (c()) return d;
                e.position = 4;
                if (c()) return d
            }
            e && e.anchor.nextSibling ? e = {anchor: e.anchor.nextSibling, position: 1} : e = null
        }
        return d
    };

    function Ue(a, b, c) {
        this.b = a;
        this.g = b;
        this.a = c
    }

    function Ve(a, b) {
        var c = {}, d = {}, e = {};
        b.forEach(function (f) {
            if (C(f, Wc, 1)) {
                f = C(f, Wc, 1);
                if (C(f, L, 1) && C(C(f, L, 1), K, 1) && C(f, L, 2) && C(C(f, L, 2), K, 1)) {
                    var g = We(a, C(C(f, L, 1), K, 1)), h = We(a, C(C(f, L, 2), K, 1));
                    if (g && h) for (g = ba(Te({anchor: g, position: z(C(f, L, 1), 2)}, {
                        anchor: h,
                        position: z(C(f, L, 2), 2)
                    })), h = g.next(); !h.done; h = g.next()) Xe(h.value, c)
                }
                C(f, L, 3) && C(C(f, L, 3), K, 1) && (g = We(a, C(C(f, L, 3), K, 1))) && Xe({
                    anchor: g,
                    position: z(C(f, L, 3), 2)
                }, c)
            } else C(f, Xc, 2) ? Ye(a, C(f, Xc, 2), d) : C(f, Yc, 3) && Ze(a, C(f, Yc, 3), e)
        });
        return new Ue(c, d, e)
    }

    function Ye(a, b, c) {
        C(b, K, 1) && (a = $e(a, C(b, K, 1))) && a.forEach(function (d) {
            d = xa(d);
            c[d] = !0
        })
    }

    function Ze(a, b, c) {
        C(b, K, 1) && (a = $e(a, C(b, K, 1))) && a.forEach(function (d) {
            d = xa(d);
            c[d] = !0
        })
    }

    function Xe(a, b) {
        var c = xa(a.anchor);
        b[c] || (b[c] = {});
        b[c][a.position] = !0
    }

    function We(a, b) {
        return (a = $e(a, b)) && 0 < a.length ? a[0] : null
    }

    function $e(a, b) {
        return (b = Pe(b)) ? Ke(b, a) : null
    };

    function af(a, b) {
        if (!a) return !1;
        a = Wb(a, b);
        if (!a) return !1;
        a = a.cssFloat || a.styleFloat;
        return "left" == a || "right" == a
    }

    function bf(a) {
        for (a = a.previousSibling; a && 1 != a.nodeType;) a = a.previousSibling;
        return a ? a : null
    }

    function cf(a) {
        return !!a.nextSibling || !!a.parentNode && cf(a.parentNode)
    };

    function df(a, b) {
        return a && null != z(a, 4) && b[z(C(a, Rc, 4), 2)] ? !1 : !0
    }

    function ef(a) {
        var b = {};
        a && z(a, 6).forEach(function (c) {
            b[c] = !0
        });
        return b
    }

    function ff(a, b, c, d) {
        this.a = p;
        this.G = a;
        this.i = b;
        this.g = d || null;
        this.b = !1;
        this.h = (this.w = c) ? Ve(p.document, D(c, Uc, 5)) : Ve(p.document, [])
    }

    function gf(a, b) {
        if (a.b) return !0;
        try {
            var c = a.a.localStorage.getItem("google_ama_settings");
            var d = c ? new ie(c ? JSON.parse(c) : null) : null
        } catch (k) {
            d = null
        }
        if (null !== d && Bb(d, 2)) return a = a.a.google_ama_state = a.a.google_ama_state || {}, a.eatf = !0, he(7, [!0, 0, !1]), !0;
        d = 0;
        var e = D(a.i, Sc, 1), f = ef(a.w);
        for (c = 0; c < e.length; c++) {
            var g = e[c];
            if (1 == z(g, 8) && df(g, f)) {
                var h = C(g, Rc, 4);
                if (h && 2 == z(h, 1) && (d++, hf(a, g, b, f))) return a.b = !0, a = a.a.google_ama_state = a.a.google_ama_state || {}, a.placement = c, he(7, [!1, d, !0]), !0
            }
        }
        he(7, [!1, d, !1]);
        return !1
    }

    function hf(a, b, c, d) {
        if (!df(b, d) || 1 != z(b, 8)) return null;
        d = C(b, K, 1);
        if (!d) return null;
        d = Pe(d);
        if (!d) return null;
        d = Ke(d, a.a.document);
        if (0 == d.length) return null;
        d = d[0];
        var e = z(b, 2);
        e = Se[e];
        e = void 0 !== e ? e : null;
        var f;
        if (!(f = null == e)) {
            a:{
                f = a.a;
                switch (e) {
                    case 0:
                        f = af(bf(d), f);
                        break a;
                    case 3:
                        f = af(d, f);
                        break a;
                    case 2:
                        var g = d.lastChild;
                        f = af(g ? 1 == g.nodeType ? g : bf(g) : null, f);
                        break a
                }
                f = !1
            }
            if (c = !f && !(!c && 2 == e && !cf(d))) c = 1 == e || 2 == e ? d : d.parentNode, c = !(c && !Fe(c) && 0 >= c.offsetWidth);
            f = !c
        }
        if (!(c = f)) {
            c = a.h;
            f = z(b, 2);
            g = xa(d);
            if (!(g = c.b[g] && c.b[g][f] ? !0 : !1)) a:{
                g = xa(d);
                if (c.a[g]) switch (f) {
                    case 2:
                    case 3:
                        g = !0;
                        break a;
                    default:
                        g = !1;
                        break a
                }
                for (f = d.parentElement; f;) {
                    g = xa(f);
                    if (c.a[g]) {
                        g = !0;
                        break a
                    }
                    f = f.parentElement
                }
                g = !1
            }
            (f = g) || (f = xa(d), f = !!c.g[f]);
            c = f
        }
        if (c) return null;
        f = C(b, Qc, 3);
        c = {};
        f && (c.xa = z(f, 1), c.ha = z(f, 2), c.Fa = !!Ab(f, 3));
        f = C(b, Rc, 4) && z(C(b, Rc, 4), 2) ? z(C(b, Rc, 4), 2) : null;
        f = Zd(f);
        b = null == z(b, 12) ? null : z(b, 12);
        b = Yd(a.g, f, null == b ? null : new Xd(null, {google_ml_rank: b}));
        f = a.a;
        a = a.G;
        var h = f.document;
        g = Mb(new Lb(h), "DIV");
        var k = g.style;
        k.textAlign = "center";
        k.width = "100%";
        k.height = "auto";
        k.clear = c.Fa ? "both" : "none";
        c.Na && Ge(k, c.Na);
        h = Mb(new Lb(h), "INS");
        k = h.style;
        k.display = "block";
        k.margin = "auto";
        k.backgroundColor = "transparent";
        c.xa && (k.marginTop = c.xa);
        c.ha && (k.marginBottom = c.ha);
        c.Ea && Ge(k, c.Ea);
        g.appendChild(h);
        c = {V: g, U: h};
        c.U.setAttribute("data-ad-format", "auto");
        g = [];
        if (h = b && b.ja) c.V.className = h.join(" ");
        h = c.U;
        h.className = "adsbygoogle";
        h.setAttribute("data-ad-client", a);
        g.length && h.setAttribute("data-ad-channel", g.join("+"));
        a:{
            try {
                var m = c.V;
                switch (e) {
                    case 0:
                        d.parentNode && d.parentNode.insertBefore(m, d);
                        break;
                    case 3:
                        var n = d.parentNode;
                        if (n) {
                            var q = d.nextSibling;
                            if (q && q.parentNode != n) for (; q && 8 == q.nodeType;) q = q.nextSibling;
                            n.insertBefore(m, q)
                        }
                        break;
                    case 1:
                        d.insertBefore(m, d.firstChild);
                        break;
                    case 2:
                        d.appendChild(m)
                }
                Fe(d) && (d.setAttribute("data-init-display", d.style.display), d.style.display = "block");
                b:{
                    var w = c.U;
                    w.setAttribute("data-adsbygoogle-status", "reserved");
                    w.className += " adsbygoogle-noablate";
                    m = {element: w};
                    var y = b && b.ra;
                    if (w.hasAttribute("data-pub-vars")) {
                        try {
                            y = JSON.parse(w.getAttribute("data-pub-vars"))
                        } catch (G) {
                            break b
                        }
                        w.removeAttribute("data-pub-vars")
                    }
                    y && (m.params = y);
                    (f.adsbygoogle = f.adsbygoogle || []).push(m)
                }
            } catch (G) {
                (w = c.V) && w.parentNode && (y = w.parentNode, y.removeChild(w), Fe(y) && (y.style.display = y.getAttribute("data-init-display") || "none"));
                w = !1;
                break a
            }
            w = !0
        }
        return w ? c : null
    };

    function jf() {
        this.b = new kf(this);
        this.a = 0
    }

    function lf(a) {
        if (0 != a.a) throw Error("Already resolved/rejected.");
    }

    function kf(a) {
        this.a = a
    }

    function mf(a) {
        switch (a.a.a) {
            case 0:
                break;
            case 1:
                a.b && a.b(a.a.h);
                break;
            case 2:
                a.g && a.g(a.a.g);
                break;
            default:
                throw Error("Unhandled deferred state.");
        }
    };

    function nf(a) {
        this.exception = a
    }

    function of(a, b) {
        this.b = p;
        this.g = a;
        this.a = b
    }

    of.prototype.start = function () {
        this.h()
    };
    of.prototype.h = function () {
        try {
            switch (this.b.document.readyState) {
                case "complete":
                case "interactive":
                    gf(this.g, !0);
                    pf(this);
                    break;
                default:
                    gf(this.g, !1) ? pf(this) : this.b.setTimeout(Ca(this.h, this), 100)
            }
        } catch (a) {
            pf(this, a)
        }
    };

    function pf(a, b) {
        try {
            var c = a.a, d = new nf(b);
            lf(c);
            c.a = 1;
            c.h = d;
            mf(c.b)
        } catch (e) {
            a = a.a, b = e, lf(a), a.a = 2, a.g = b, mf(a.b)
        }
    };

    function qf(a) {
        ce(a, {atf: 1})
    }

    function rf(a, b) {
        (a.google_ama_state = a.google_ama_state || {}).exception = b;
        ce(a, {atf: 0})
    };

    function sf() {
        this.debugCard = null;
        this.debugCardRequested = !1
    };

    function tf(a, b) {
        if (!a) return !1;
        a = a.hash;
        if (!a || !a.indexOf) return !1;
        if (-1 != a.indexOf(b)) return !0;
        b = uf(b);
        return "go" != b && -1 != a.indexOf(b) ? !0 : !1
    }

    function uf(a) {
        var b = "";
        Cc(a.split("_"), function (c) {
            b += c.substr(0, 2)
        });
        return b
    };var vf = {
        9: "400",
        10: "100",
        13: "0.001",
        19: "0.01",
        22: "0.01",
        24: "0.05",
        28: "0.001",
        29: "0.01",
        34: "0.001",
        60: "0.03",
        66: "0.1",
        76: "0.0",
        78: "0.1",
        79: "1200",
        82: "3",
        83: "1.0",
        96: "700",
        97: "20",
        98: "0.01",
        99: "600",
        100: "100",
        103: "0.01",
        111: "0.1",
        118: "false",
        120: "0",
        121: "1000",
        126: "0.001",
        128: "false",
        129: "0.02",
        135: "0.01",
        136: "0.02",
        137: "0.01",
        142: "1",
        149: "0",
        150: "1000",
        152: "700",
        153: "20",
        155: "0.06",
        157: "1",
        158: "100",
        159: "0.05",
        160: "250",
        161: "150",
        162: "0.1",
        165: "0.02",
        166: "100",
        167: "0",
        169: "0",
        170: "100",
        172: "0.05",
        173: "800",
        174: "2",
        176: "0.02",
        177: "0.02",
        178: "0.02",
        179: "0",
        180: "100",
        181: "1",
        182: "0.1",
        183: "0",
        184: "2",
        185: "0.02"
    };
    var xf = null;

    function yf() {
        this.a = vf
    }

    function Q(a, b) {
        a = parseFloat(a.a[b]);
        return isNaN(a) ? 0 : a
    }

    function zf() {
        xf || (xf = new yf);
        return xf
    };

    function Af(a, b, c) {
        var d = "script";
        d = void 0 === d ? "" : d;
        var e = a.createElement("link");
        try {
            e.rel = "preload";
            if (ab("preload", "stylesheet")) var f = Ta(b).toString(); else {
                if (b instanceof Ra) var g = Ta(b).toString(); else {
                    if (b instanceof db) var h = gb(b); else {
                        if (b instanceof db) var k = b; else b = "object" == typeof b && b.g ? b.b() : String(b), hb.test(b) || (b = "about:invalid#zClosurez"), k = ib(b);
                        h = gb(k)
                    }
                    g = h
                }
                f = g
            }
            e.href = f
        } catch (m) {
            return
        }
        d && (e.as = d);
        c && e.setAttribute("nonce", c);
        if (a = a.getElementsByTagName("head")[0]) try {
            a.appendChild(e)
        } catch (m) {
        }
    };

    function Bf(a) {
        if (!a) return "";
        (a = a.toLowerCase()) && "ca-" != a.substring(0, 3) && (a = "ca-" + a);
        return a
    };

    function Cf(a, b) {
        function c(d) {
            try {
                var e = new Fb(d);
                return Ia(D(e, Hb, 2), function (f) {
                    return 1 == z(f, 1)
                })
            } catch (f) {
                return null
            }
        }

        b = void 0 === b ? "" : b;
        a = Lc(a) || a;
        a = Df(a);
        return b ? (b = Bf(String(b)), a[b] ? c(a[b]) : null) : Ia(Ha(Pa(a), c), function (d) {
            return null != d
        })
    }

    function Ef(a, b, c) {
        function d(e) {
            if (!e) return !1;
            e = new Fb(e);
            return z(e, 3) && Ka(z(e, 3), b)
        }

        c = void 0 === c ? "" : c;
        a = Lc(a) || a;
        if (Ff(a, b)) return !0;
        a = Df(a);
        return c ? (c = Bf(String(c)), d(a[c])) : Oa(a, d)
    }

    function Ff(a, b) {
        a = (a = (a = a.location && a.location.hash) && a.match(/forced_clientside_labs=([\d,]+)/)) && a[1];
        return !!a && Ka(a.split(","), b.toString())
    }

    function Df(a) {
        try {
            return jc({}, JSON.parse(a.localStorage.getItem("google_adsense_settings")))
        } catch (b) {
            return {}
        }
    };var Gf = {c: "368226950", f: "368226951"}, Hf = {c: "368226960", f: "368226961"},
        If = {c: "368226350", f: "368226351"}, Jf = {c: "368226360", f: "368226361"},
        Kf = {c: "332260030", M: "332260031", L: "332260032"}, Lf = {c: "332260040", M: "332260041", L: "332260042"},
        Mf = {c: "368226500", f: "368226501"}, Nf = {c: "36998750", f: "36998751"},
        Of = {c: "633794000", B: "633794004"}, Pf = {c: "633794002", B: "633794005"},
        Qf = {c: "221415700", f: "221415701"}, Rf = {c: "221415800", f: "221415801"},
        Sf = {c: "231196899", f: "231196900"}, Tf = {c: "231196901", f: "231196902"},
        Uf = {c: "4089040", Ba: "4089042"}, Vf = {m: "20040067", c: "20040068", ca: "1337"},
        Wf = {c: "21060548", m: "21060549"}, Xf = {c: "21060623", m: "21060624"}, Yf = {c: "22324606", f: "22324607"},
        Zf = {c: "21062271", m: "21062272"},
        $f = {c: "21060849", fa: "21060850", T: "21060851", ea: "21060852", da: "21060853"},
        ag = {c: "182982000", f: "182982100"}, bg = {c: "182982200", f: "182982300"},
        cg = {c: "182983000", f: "182983100"}, dg = {c: "182983200", f: "182983300"},
        eg = {c: "182984000", f: "182984100"}, fg = {c: "182984200", f: "182984300"},
        gg = {c: "229739148", f: "229739149"}, hg = {c: "229739146", f: "229739147"},
        ig = {c: "20040012", f: "20040013"}, jg = {c: "21062908", R: "21062910"}, kg = {c: "21063597", f: "21063598"};

    function lg(a) {
        if (p.google_apltlad || Kc(p) != p) return null;
        var b = Ef(p, 12, a.google_ad_client);
        var c = "google_ad_host" in a, d = I(p, Gf.f), e = tf(p.location, "google_ads_preview");
        b = b && !c && d || e;
        c = I(p, If.f);
        if (!b && !c) return null;
        p.google_apltlad = !0;
        a = a.google_ad_client;
        d = {};
        e = {};
        a = (e.enable_page_level_ads = (d.pltais = !0, d), e.google_ad_client = a, e);
        b ? a.enable_page_level_ads.google_ad_channel = "AutoInsertAutoAdCode" : c && (a.enable_page_level_ads.google_pgb_reactive = 7);
        return a
    }

    function mg(a) {
        return wa(a.enable_page_level_ads) && 7 == a.enable_page_level_ads.google_pgb_reactive
    };

    function Rd(a) {
        try {
            var b = H(p).eids || [];
            null != b && 0 < b.length && (a.eid = b.join(","))
        } catch (c) {
        }
    }

    function Qd(a) {
        a.shv = rc()
    }

    Nd.h = !sc;

    function ng(a, b) {
        return pe(b, a) + we(b, a, "height", F)
    };

    function og(a) {
        x(this, a, pg, null)
    }

    t(og, v);

    function qg(a) {
        x(this, a, rg, null)
    }

    t(qg, v);

    function sg(a) {
        x(this, a, tg, null)
    }

    t(sg, v);

    function ug(a) {
        x(this, a, vg, null)
    }

    t(ug, v);

    function wg(a) {
        x(this, a, xg, yg)
    }

    t(wg, v);

    function zg(a) {
        x(this, a, null, null)
    }

    t(zg, v);

    function Ag(a) {
        x(this, a, Bg, null)
    }

    t(Ag, v);

    function Cg(a) {
        x(this, a, Dg, Eg)
    }

    t(Cg, v);
    var pg = [1, 2], rg = [2], tg = [2], vg = [2];
    ug.prototype.N = function () {
        return A(this, 1, 0)
    };
    var xg = [5], yg = [[1, 2, 3, 6]], Bg = [4], Dg = [2, 8], Eg = [[3, 4, 5], [6, 7]];

    function Fg(a) {
        return null != a ? !a : a
    }

    function Gg(a, b) {
        for (var c = !1, d = 0; d < a.length; d++) {
            var e = a[d].call();
            if (e == b) return e;
            null == e && (c = !0)
        }
        if (!c) return !b
    }

    function Hg(a, b) {
        var c = D(a, Cg, 2);
        if (!c.length) return Ig(a, b);
        a = A(a, 1, 0);
        if (1 == a) return Fg(Hg(c[0], b));
        c = Ha(c, function (d) {
            return function () {
                return Hg(d, b)
            }
        });
        switch (a) {
            case 2:
                return Gg(c, !1);
            case 3:
                return Gg(c, !0)
        }
    }

    function Ig(a, b) {
        var c = zb(a, Eg[0]);
        a:{
            switch (c) {
                case 3:
                    var d = A(a, 3, 0);
                    break a;
                case 4:
                    d = A(a, 4, 0);
                    break a;
                case 5:
                    d = A(a, 5, 0);
                    break a
            }
            d = void 0
        }
        if (d && (b = (b = b[c]) && b[d])) {
            try {
                var e = b.apply(null, z(a, 8))
            } catch (f) {
                return
            }
            b = A(a, 1, 0);
            if (4 == b) return !!e;
            d = null != e;
            if (5 == b) return d;
            a:{
                switch (c) {
                    case 4:
                        a = Cb(a, 6);
                        break a;
                    case 5:
                        a = A(a, 7, "");
                        break a
                }
                a = void 0
            }
            if (null != a) {
                if (6 == b) return e === a;
                if (9 == b) return 0 == bb(e, a);
                if (d) switch (b) {
                    case 7:
                        return e < a;
                    case 8:
                        return e > a;
                    case 12:
                        return (new RegExp(a)).test(e);
                    case 10:
                        return -1 == bb(e, a);
                    case 11:
                        return 1 == bb(e, a)
                }
            }
        }
    }

    function Jg(a, b) {
        return !a || !(!b || !Hg(a, b))
    };

    function Kg() {
        var a = {};
        this.a = (a[3] = {}, a[4] = {}, a[5] = {}, a)
    }

    ta(Kg);

    function Lg(a, b) {
        switch (b) {
            case 1:
                return A(a, 1, 0);
            case 2:
                return A(a, 2, 0);
            case 3:
                return A(a, 3, 0);
            case 6:
                return A(a, 6, 0);
            default:
                return null
        }
    }

    function Mg(a, b) {
        if (!a) return null;
        switch (b) {
            case 1:
                return Bb(a, 1);
            case 2:
                return Cb(a, 2);
            case 3:
                return A(a, 3, "");
            case 6:
                return z(a, 4);
            default:
                return null
        }
    }

    var Ng = Ma(function () {
        var a = "";
        try {
            a = p.top.location.hash
        } catch (c) {
            a = p.location.hash
        }
        var b = {};
        if (a = (a = /\bdflags=({.*})(&|$)/.exec(a)) && a[1]) try {
            b = JSON.parse(decodeURIComponent(a))
        } catch (c) {
        }
        return b
    });

    function Og(a, b, c) {
        var d = Ng();
        if (d[a] && null != d[a][b]) return d[a][b];
        b = Pg.u().a[a][b];
        if (!b) return c;
        b = new wg(b);
        b = Qg(b);
        a = Mg(b, a);
        return null != a ? a : c
    }

    function Qg(a) {
        var b = Kg.u().a;
        if (b) {
            var c = Ja(D(a, zg, 5), function (d) {
                return Jg(C(d, Cg, 1), b)
            });
            if (c) return C(c, Ag, 2)
        }
        return C(a, Ag, 4)
    }

    function Pg() {
        var a = {};
        this.a = (a[1] = {}, a[2] = {}, a[3] = {}, a[6] = {}, a)
    }

    ta(Pg);

    function Rg(a, b) {
        return Og(1, a, void 0 === b ? !1 : b)
    }

    function Sg(a, b) {
        return Og(2, a, void 0 === b ? 0 : b)
    }

    function Tg(a, b) {
        return Og(3, a, void 0 === b ? "" : b)
    }

    function Ug(a, b) {
        b = void 0 === b ? [] : b;
        return Og(6, a, b)
    }

    function Vg(a) {
        var b = Pg.u().a;
        Fa(a, function (c) {
            var d = zb(c, yg[0]), e = Lg(c, d);
            e && (b[d][e] = Eb(c))
        })
    };

    function Wg(a) {
        this.a = a
    }

    var Xg = new Wg(1), Yg = new Wg(2), Zg = new Wg(3), $g = new Wg(4), ah = new Wg(5), bh = new Wg(6), ch = new Wg(7),
        dh = new Wg(8), eh = new Wg(9), fh = new Wg(10), gh = new Wg(11);

    function hh(a, b, c) {
        c.hasOwnProperty(a.a) || Object.defineProperty(c, String(a.a), {value: b})
    }

    function ih(a) {
        hh(ah, Rg, a);
        hh(bh, Sg, a);
        hh(ch, Tg, a);
        hh(dh, Ug, a)
    }

    function jh(a) {
        hh($g, function (b) {
            Kg.u().a = b
        }, a);
        hh(eh, function (b, c) {
            var d = Kg.u();
            d.a[3][b] || (d.a[3][b] = c)
        }, a);
        hh(fh, function (b, c) {
            var d = Kg.u();
            d.a[4][b] || (d.a[4][b] = c)
        }, a);
        hh(gh, function (b, c) {
            var d = Kg.u();
            d.a[5][b] || (d.a[5][b] = c)
        }, a)
    };

    function kh(a, b) {
        var c = this, d = void 0 === b ? {} : b;
        b = void 0 === d.Ia ? !1 : d.Ia;
        var e = void 0 === d.Ma ? {} : d.Ma;
        d = void 0 === d.Ua ? [] : d.Ua;
        this.b = a;
        this.i = b;
        this.g = e;
        this.h = d;
        this.a = {};
        (a = xd()) && Fa(a.split(",") || [], function (f) {
            (f = parseInt(f, 10)) && (c.a[f] = !0)
        })
    }

    function lh(a, b) {
        var c = [], d = mh(a, b);
        d && (9 !== b && nh(a, b), Fa(d, function (e) {
            if (e = oh(a, e)) {
                var f = e.N();
                c.push(f);
                a.h.push(f);
                (e = D(e, wg, 2)) && Vg(e)
            }
        }));
        return c
    }

    function mh(a, b) {
        return (a = Ia(a.b, function (c) {
            return A(c, 1, 0) == b
        })) && D(a, sg, 2)
    }

    function nh(a, b) {
        a.b = Ga(a.b, function (c) {
            return A(c, 1, 0) != b
        })
    }

    function oh(a, b) {
        var c = Kg.u().a;
        if (!Jg(C(b, Cg, 3), c)) return null;
        var d = D(b, ug, 2), e = c ? Ga(d, function (g) {
            return Jg(C(g, Cg, 3), c)
        }) : d, f = e.length;
        if (!f) return null;
        d = A(b, 4, 0);
        b = f * A(b, 1, 0);
        if (!d) return ph(a, e, b / 1E3);
        f = null != a.g[d] ? a.g[d] : 1E3;
        if (0 >= f) return null;
        e = ph(a, e, b / f);
        a.g[d] = e ? 0 : f - b;
        return e
    }

    function ph(a, b, c) {
        var d = a.a, e = Ia(b, function (f) {
            return !!d[f.N()]
        });
        return e ? e : a.i ? null : Xb(b, c, !1)
    }

    function qh(a, b) {
        hh(Xg, function (c) {
            a.a[c] = !0
        }, b);
        hh(Yg, function (c) {
            return lh(a, c)
        }, b);
        hh(Zg, function () {
            return a.h
        }, b);
        ih(b);
        jh(b)
    };

    function rh() {
    }

    ta(rh);

    function sh() {
        var a = new og(yc);
        kh.call(this, D(a, qg, 2));
        a = D(a, wg, 1);
        Vg(a);
        var b = void 0 === b ? p : b;
        b = b.ggeac || (b.ggeac = {});
        qh(this, b);
        rh.u()
    }

    ja(sh, kh);
    ta(sh);
    var th = new M(100, 199, ""), uh = new M(200, 399, ""), vh = new M(400, 499, ""), wh = new M(0, 100, "4"),
        xh = new M(600, 699, ""), yh = new M(700, 799, ""), zh = new M(800, 899, ""), Ah = new M(1, 399, "3"),
        Bh = new M(0, 999, "5"), Ch = new M(0, 10, "2");

    function R(a, b) {
        b && a.push(b)
    }

    function Dh(a, b) {
        for (var c = [], d = 1; d < arguments.length; ++d) c[d - 1] = arguments[d];
        d = Lc(a) || a;
        d = (d = (d = d.location && d.location.hash) && (d.match(/google_plle=([\d,]+)/) || d.match(/deid=([\d,]+)/))) && d[1];
        var e;
        if (e = !!d) a:{
            d = Da(ab, d);
            e = c.length;
            for (var f = r(c) ? c.split("") : c, g = 0; g < e; g++) if (g in f && d.call(void 0, f[g], g, c)) {
                e = !0;
                break a
            }
            e = !1
        }
        return e
    }

    function S(a, b, c) {
        for (var d = 0; d < c.length; d++) if (Dh(a, c[d])) return c[d];
        return Xb(c, b)
    }

    function T(a, b, c, d, e, f) {
        f = void 0 === f ? 1 : f;
        for (var g = 0; g < e.length; g++) if (Dh(a, e[g])) return e[g];
        f = void 0 === f ? 1 : f;
        0 >= d ? c = null : (g = new ud(c, c + d - 1), (d = d % f || d / f % e.length) || (d = b.b, d = !(d.start <= g.start && d.a >= g.a)), d ? c = null : (a = vd(a, b.a), c = null !== a && g.start <= a && g.a >= a ? e[Math.floor((a - c) / f) % e.length] : null));
        return c
    };

    function Eh(a, b, c) {
        if (Qb(a.document.getElementById(b).contentWindow)) a = a.document.getElementById(b).contentWindow, b = a.document, b.body && b.body.firstChild || (/Firefox/.test(navigator.userAgent) ? b.open("text/html", "replace") : b.open(), a.google_async_iframe_close = !0, b.write(c)); else {
            a = a.document.getElementById(b).contentWindow;
            c = String(c);
            b = ['"'];
            for (var d = 0; d < c.length; d++) {
                var e = c.charAt(d), f = e.charCodeAt(0), g = d + 1, h;
                if (!(h = sb[e])) {
                    if (!(31 < f && 127 > f)) if (f = e, f in tb) e = tb[f]; else if (f in sb) e = tb[f] = sb[f]; else {
                        h = f.charCodeAt(0);
                        if (31 < h && 127 > h) e = f; else {
                            if (256 > h) {
                                if (e = "\\x", 16 > h || 256 < h) e += "0"
                            } else e = "\\u", 4096 > h && (e += "0");
                            e += h.toString(16).toUpperCase()
                        }
                        e = tb[f] = e
                    }
                    h = e
                }
                b[g] = h
            }
            b.push('"');
            a.location.replace("javascript:" + b.join(""))
        }
    };var Fh = null;

    function U(a, b, c, d) {
        d = void 0 === d ? !1 : d;
        P.call(this, a, b);
        this.O = c;
        this.Ka = d
    }

    ja(U, P);
    U.prototype.Z = function () {
        return this.O
    };
    U.prototype.P = function (a, b, c, d) {
        if (!c.google_ad_resize) {
            d.style.height = this.height() + "px";
            b = I(a, Of.c);
            a = I(a, Of.B);
            if (b || a) c.ovlp = !0;
            b ? c.rpe = !1 : a && (c.rpe = !0)
        }
    };

    function Gh(a) {
        return function (b) {
            return !!(b.O & a)
        }
    };var Hh = vb("script");

    function Ih(a, b, c, d, e, f, g, h, k, m, n, q, w, y) {
        this.pa = a;
        this.a = b;
        this.O = void 0 === c ? null : c;
        this.g = void 0 === d ? null : d;
        this.aa = void 0 === e ? null : e;
        this.b = void 0 === f ? null : f;
        this.h = void 0 === g ? null : g;
        this.G = void 0 === h ? !1 : h;
        this.na = void 0 === k ? !1 : k;
        this.ya = void 0 === m ? null : m;
        this.za = void 0 === n ? null : n;
        this.i = void 0 === q ? null : q;
        this.w = void 0 === w ? null : w;
        this.Aa = void 0 === y ? null : y;
        this.ba = this.va = this.qa = null
    }

    function Jh(a, b, c) {
        null != a.O && (c.google_responsive_formats = a.O);
        null != a.aa && (c.google_safe_for_responsive_override = a.aa);
        null != a.b && (!0 === a.b ? c.google_full_width_responsive_allowed = !0 : (c.google_full_width_responsive_allowed = !1, c.gfwrnwer = a.b));
        null != a.h && !0 !== a.h && (c.gfwrnher = a.h);
        a.G && (c.google_bfa = a.G);
        a.na && (c.ebfa = a.na);
        var d = a.w || c.google_ad_width;
        null != d && (c.google_resizing_width = d);
        d = a.i || c.google_ad_height;
        null != d && (c.google_resizing_height = d);
        d = a.a.I(b);
        var e = a.a.height();
        c.google_ad_resize || (c.google_ad_width = d, c.google_ad_height = e, c.google_ad_format = a.a.W(b), c.google_responsive_auto_format = a.pa, null != a.g && (c.armr = a.g), c.google_ad_resizable = !0, c.google_override_format = 1, c.google_loader_features_used = 128, !0 === a.b && (c.gfwrnh = a.a.height() + "px"));
        null != a.ya && (c.gfwroml = a.ya);
        null != a.za && (c.gfwromr = a.za);
        null != a.i && (c.gfwroh = a.i);
        null != a.w && (c.gfwrow = a.w);
        null != a.Aa && (c.gfwroz = a.Aa);
        null != a.qa && (c.gml = a.qa);
        null != a.va && (c.gmr = a.va);
        null != a.ba && (c.gzi = a.ba);
        b = Ic();
        b = Lc(b) || b;
        tf(b.location, "google_responsive_slot_debug") && (c.ds = "outline:thick dashed " + (d && e ? !0 !== a.b || !0 !== a.h ? "#ffa500" : "#0f0" : "#f00") + " !important;");
        !tf(b.location, "google_responsive_dummy_ad") || !Ka([1, 2, 3, 4, 5, 6, 7, 8], a.pa) && 1 !== a.g || c.google_ad_resize || 2 === a.g || (a = JSON.stringify({
            googMsgType: "adpnt",
            key_value: [{key: "qid", value: "DUMMY_AD"}]
        }), c.dash = "<" + Hh + ">window.top.postMessage('" + a + "', '*');\n          </" + Hh + '>\n          <div id="dummyAd" style="width:' + d + "px;height:" + e + 'px;\n            background:#ddd;border:3px solid #f00;box-sizing:border-box;\n            color:#000;">\n            <p>Requested size:' + d + "x" + e + "</p>\n            <p>Rendered size:" + d + "x" + e + "</p>\n          </div>")
    };/*

 Copyright 2019 The AMP HTML Authors. All Rights Reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS-IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
    var Kh = {},
        Lh = (Kh.image_stacked = 1 / 1.91, Kh.image_sidebyside = 1 / 3.82, Kh.mobile_banner_image_sidebyside = 1 / 3.82, Kh.pub_control_image_stacked = 1 / 1.91, Kh.pub_control_image_sidebyside = 1 / 3.82, Kh.pub_control_image_card_stacked = 1 / 1.91, Kh.pub_control_image_card_sidebyside = 1 / 3.74, Kh.pub_control_text = 0, Kh.pub_control_text_card = 0, Kh),
        Mh = {},
        Nh = (Mh.image_stacked = 80, Mh.image_sidebyside = 0, Mh.mobile_banner_image_sidebyside = 0, Mh.pub_control_image_stacked = 80, Mh.pub_control_image_sidebyside = 0, Mh.pub_control_image_card_stacked = 85, Mh.pub_control_image_card_sidebyside = 0, Mh.pub_control_text = 80, Mh.pub_control_text_card = 80, Mh),
        Oh = {},
        Ph = (Oh.pub_control_image_stacked = 100, Oh.pub_control_image_sidebyside = 200, Oh.pub_control_image_card_stacked = 150, Oh.pub_control_image_card_sidebyside = 250, Oh.pub_control_text = 100, Oh.pub_control_text_card = 150, Oh);

    function Qh(a) {
        var b = 0;
        a.A && b++;
        a.o && b++;
        a.s && b++;
        if (3 > b) return {v: "Tags data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num should be set together."};
        b = a.A.split(",");
        var c = a.s.split(",");
        a = a.o.split(",");
        if (b.length !== c.length || b.length !== a.length) return {v: 'Lengths of parameters data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num must match. Example: \n data-matched-content-rows-num="4,2"\ndata-matched-content-columns-num="1,6"\ndata-matched-content-ui-type="image_stacked,image_card_sidebyside"'};
        if (2 < b.length) return {v: "The parameter length of attribute data-matched-content-ui-type, data-matched-content-columns-num and data-matched-content-rows-num is too long. At most 2 parameters for each attribute are needed: one for mobile and one for desktop, while " + ("you are providing " + b.length + ' parameters. Example: \n data-matched-content-rows-num="4,2"\ndata-matched-content-columns-num="1,6"\ndata-matched-content-ui-type="image_stacked,image_card_sidebyside".')};
        for (var d = [], e = [], f = 0; f < b.length; f++) {
            var g = Number(c[f]);
            if (isNaN(g) || 0 === g) return {v: "Wrong value '" + c[f] + "' for data-matched-content-rows-num."};
            d.push(g);
            g = Number(a[f]);
            if (isNaN(g) || 0 === g) return {v: "Wrong value '" + a[f] + "' for data-matched-content-columns-num."};
            e.push(g)
        }
        return {s: d, o: e, oa: b}
    }

    function Rh(a) {
        return 1200 <= a ? {width: 1200, height: 600} : 850 <= a ? {
            width: a,
            height: Math.floor(.5 * a)
        } : 550 <= a ? {width: a, height: Math.floor(.6 * a)} : 468 <= a ? {
            width: a,
            height: Math.floor(.7 * a)
        } : {width: a, height: Math.floor(3.44 * a)}
    };var Sh = ["google_content_recommendation_ui_type", "google_content_recommendation_columns_num", "google_content_recommendation_rows_num"];

    function Th(a, b) {
        P.call(this, a, b)
    }

    ja(Th, P);
    Th.prototype.I = function (a) {
        return Math.min(1200, Math.max(this.minWidth(), Math.round(a)))
    };

    function Uh(a, b) {
        Vh(a, b);
        if ("pedestal" == b.google_content_recommendation_ui_type) return new Ih(9, new Th(a, Math.floor(a * b.google_phwr)));
        var c = Pb();
        468 > a ? c ? (c = a - 8 - 8, c = Math.floor(c / 1.91 + 70) + Math.floor(11 * (c * Lh.mobile_banner_image_sidebyside + Nh.mobile_banner_image_sidebyside) + 96), a = {
            K: a,
            J: c,
            o: 1,
            s: 12,
            A: "mobile_banner_image_sidebyside"
        }) : (a = Rh(a), a = {
            K: a.width,
            J: a.height,
            o: 1,
            s: 13,
            A: "image_sidebyside"
        }) : (a = Rh(a), a = {K: a.width, J: a.height, o: 4, s: 2, A: "image_stacked"});
        Wh(b, a);
        return new Ih(9, new Th(a.K, a.J))
    }

    function Xh(a, b) {
        Vh(a, b);
        var c = Qh({
            s: b.google_content_recommendation_rows_num,
            o: b.google_content_recommendation_columns_num,
            A: b.google_content_recommendation_ui_type
        });
        if (c.v) a = {K: 0, J: 0, o: 0, s: 0, A: "image_stacked", v: c.v}; else {
            var d = 2 === c.oa.length && 468 <= a ? 1 : 0;
            var e = c.oa[d];
            e = 0 === e.indexOf("pub_control_") ? e : "pub_control_" + e;
            var f = Ph[e];
            for (var g = c.o[d]; a / g < f && 1 < g;) g--;
            f = g;
            c = c.s[d];
            d = Math.floor(((a - 8 * f - 8) / f * Lh[e] + Nh[e]) * c + 8 * c + 8);
            a = 1500 < a ? {width: 0, height: 0, $: "Calculated slot width is too large: " + a} : 1500 < d ? {
                width: 0,
                height: 0,
                $: "Calculated slot height is too large: " + d
            } : {width: a, height: d};
            a = a.$ ? {K: 0, J: 0, o: 0, s: 0, A: e, v: a.$} : {K: a.width, J: a.height, o: f, s: c, A: e}
        }
        if (a.v) throw new N(a.v);
        Wh(b, a);
        return new Ih(9, new Th(a.K, a.J))
    }

    function Vh(a, b) {
        if (0 >= a) throw new N("Invalid responsive width from Matched Content slot " + b.google_ad_slot + ": " + a + ". Please ensure to put this Matched Content slot into a non-zero width div container.");
    }

    function Wh(a, b) {
        a.google_content_recommendation_ui_type = b.A;
        a.google_content_recommendation_columns_num = b.o;
        a.google_content_recommendation_rows_num = b.s
    };

    function Yh(a, b) {
        P.call(this, a, b)
    }

    ja(Yh, P);
    Yh.prototype.I = function () {
        return this.minWidth()
    };
    Yh.prototype.P = function (a, b, c, d) {
        var e = this.I(b);
        ve(a, d, d.parentElement, b, e, c);
        if (!c.google_ad_resize) {
            d.style.height = this.height() + "px";
            b = I(a, Of.c);
            d = I(a, Of.B);
            if (b || d) c.ovlp = !0;
            b ? c.rpe = !1 : d && (c.rpe = !0);
            if (I(a, Lf.c) || I(a, Lf.M) || I(a, Lf.L)) c.ovlp = !0
        }
    };

    function Zh(a) {
        return function (b) {
            for (var c = a.length - 1; 0 <= c; --c) if (!a[c](b)) return !1;
            return !0
        }
    }

    function $h(a, b, c) {
        for (var d = a.length, e = null, f = 0; f < d; ++f) {
            var g = a[f];
            if (b(g)) {
                if (!c || c(g)) return g;
                null === e && (e = g)
            }
        }
        return e
    };var V = [new U(970, 90, 2), new U(728, 90, 2), new U(468, 60, 2), new U(336, 280, 1), new U(320, 100, 2), new U(320, 50, 2), new U(300, 600, 4), new U(300, 250, 1), new U(250, 250, 1), new U(234, 60, 2), new U(200, 200, 1), new U(180, 150, 1), new U(160, 600, 4), new U(125, 125, 1), new U(120, 600, 4), new U(120, 240, 4), new U(120, 120, 1, !0)],
        ai = [V[6], V[12], V[3], V[0], V[7], V[14], V[1], V[8], V[10], V[4], V[15], V[2], V[11], V[5], V[13], V[9], V[16]];

    function bi(a, b, c, d, e) {
        "false" != e.google_full_width_responsive || c.location && "#gfwrffwaifhp" == c.location.hash ? "autorelaxed" == b && (e.google_full_width_responsive || I(c, gg.f)) || ci(b) || e.google_ad_resize ? (b = te(a, c, d, e), c = !0 !== b ? {
            j: a,
            l: b
        } : {j: O(c) || a, l: !0}) : c = {j: a, l: 2} : c = {j: a, l: 1};
        b = c.l;
        return !0 !== b ? {j: a, l: b} : d.parentElement ? {j: c.j, l: b} : {j: a, l: b}
    }

    function di(a, b, c, d, e) {
        var f = Sd(247, function () {
            return bi(a, b, c, d, e)
        }), g = f.j;
        f = f.l;
        var h = !0 === f, k = F(d.style.width), m = F(d.style.height), n = ei(g, b, c, d, e, h);
        g = n.H;
        h = n.F;
        var q = n.C, w = n.D, y = n.Z;
        n = n.La;
        var G = fi(b, y), B, J = (B = we(d, c, "marginLeft", F)) ? B + "px" : "",
            eb = (B = we(d, c, "marginRight", F)) ? B + "px" : "";
        B = we(d, c, "zIndex") || "";
        return new Ih(G, g, y, null, n, f, h, q, w, J, eb, m, k, B)
    }

    function ci(a) {
        return "auto" == a || /^((^|,) *(horizontal|vertical|rectangle) *)+$/.test(a)
    }

    function ei(a, b, c, d, e, f) {
        b = "auto" == b ? .25 >= a / Math.min(1200, O(c)) ? 4 : 3 : re(b);
        var g = !1, h = !1, k = I(c, Of.B);
        if (k && 488 > O(c) || !k && Pb()) {
            var m = qe(d, c);
            var n = ze(d, c);
            g = !n && m;
            h = n && m
        }
        n = (g || k ? ai : V).slice(0);
        var q = 488 > O(c), w = [xe(a), ye(q, c, d, h), Gh(b)];
        null != e.google_max_responsive_height && w.push(Be(e.google_max_responsive_height));
        k || w.push(gi(q));
        q = [function (G) {
            return !G.Ka
        }];
        if (g || h) g = g && !k ? Ce(c, d) : De(c, d), q.push(Be(g));
        var y = $h(n, Zh(w), Zh(q));
        if (!y) throw new N("No slot size for availableWidth=" + a);
        g = Sd(248, function () {
            var G;
            a:if (f) {
                if (e.gfwrnh && (G = F(e.gfwrnh))) {
                    G = {H: new Yh(a, G), F: !0, C: !1, D: !1};
                    break a
                }
                if (I(c, Of.B) || "true" == e.google_full_width_responsive || !ze(d, c) || e.google_resizing_allowed) {
                    G = !1;
                    var B = me(c).clientHeight, J = pe(d, c), eb = c.google_lpabyc;
                    var Zc = pe(d, c);
                    var wf = me(c).clientHeight;
                    if ((Zc = 0 == wf ? null : Zc / wf) && 2 < Zc && !c.google_bfabyc && (!eb || J - eb > B) && (B = .9 * me(c).clientHeight, J = Math.min(B, hi(c, d, e)), B && J == B)) {
                        J = c.google_pbfabyc;
                        G = !J;
                        if (I(c, Lf.M) || I(c, Lf.L)) {
                            c.google_bfabyc = pe(d, c) + B;
                            G = {H: new Yh(a, Math.floor(B)), F: !0, C: !0, D: !0};
                            break a
                        }
                        J || (c.google_pbfabyc = pe(d, c) + B)
                    }
                    B = a / 1.2;
                    J = Math.min(B, hi(c, d, e));
                    if (J < .5 * B || 100 > J) J = B;
                    G = {H: new Yh(a, Math.floor(J)), F: J < B ? 102 : !0, C: !1, D: G}
                } else G = {H: new Yh(a, y.height()), F: 101, C: !1, D: !1}
            } else G = {H: y, F: 100, C: !1, D: !1};
            return G
        });
        return {H: g.H, F: g.F, C: g.C, D: g.D, Z: b, La: m}
    }

    function hi(a, b, c) {
        return c.google_resizing_allowed || "true" == c.google_full_width_responsive ? Infinity : Ce(a, b)
    }

    function fi(a, b) {
        if ("auto" == a) return 1;
        switch (b) {
            case 2:
                return 2;
            case 1:
                return 3;
            case 4:
                return 4;
            case 3:
                return 5;
            case 6:
                return 6;
            case 5:
                return 7;
            case 7:
                return 8
        }
        throw Error("bad mask");
    }

    function gi(a) {
        return function (b) {
            return !(320 == b.minWidth() && (a && 50 == b.height() || !a && 100 == b.height()))
        }
    };var ii = {
        "image-top": function (a) {
            return 600 >= a ? 284 + .414 * (a - 250) : 429
        }, "image-middle": function (a) {
            return 500 >= a ? 196 - .13 * (a - 250) : 164 + .2 * (a - 500)
        }, "image-side": function (a) {
            return 500 >= a ? 205 - .28 * (a - 250) : 134 + .21 * (a - 500)
        }, "text-only": function (a) {
            return 500 >= a ? 187 - .228 * (a - 250) : 130
        }, "in-article": function (a) {
            return 420 >= a ? a / 1.2 : 460 >= a ? a / 1.91 + 130 : 800 >= a ? a / 4 : 200
        }
    };

    function ji(a, b) {
        P.call(this, a, b)
    }

    ja(ji, P);
    ji.prototype.I = function () {
        return Math.min(1200, this.minWidth())
    };

    function ki(a, b, c, d, e) {
        var f = e.google_ad_layout || "image-top";
        if ("in-article" == f && "false" != e.google_full_width_responsive) {
            var g = se(b, c, a, .2, e);
            if (!0 !== g) e.gfwrnwer = g; else if (g = O(b)) {
                e.google_full_width_responsive_allowed = !0;
                var h = c.parentElement;
                if (h) {
                    b:for (var k = c, m = 0; 100 > m && k.parentElement; ++m) {
                        for (var n = k.parentElement.childNodes, q = 0; q < n.length; ++q) {
                            var w = n[q];
                            if (w != k && ue(b, w)) break b
                        }
                        k = k.parentElement;
                        k.style.width = "100%";
                        k.style.height = "auto"
                    }
                    ve(b, c, h, a, g, e);
                    a = g
                }
            }
        }
        if (250 > a) throw new N("Fluid responsive ads must be at least 250px wide: availableWidth=" + a);
        b = Math.min(1200, Math.floor(a));
        if (d && "in-article" != f) {
            f = Math.ceil(d);
            if (50 > f) throw new N("Fluid responsive ads must be at least 50px tall: height=" + f);
            return new Ih(11, new P(b, f))
        }
        if ("in-article" != f && (d = e.google_ad_layout_key)) {
            f = "" + d;
            d = Math.pow(10, 3);
            if (c = (e = f.match(/([+-][0-9a-z]+)/g)) && e.length) {
                a = [];
                for (g = 0; g < c; g++) a.push(parseInt(e[g], 36) / d);
                d = a
            } else d = null;
            if (!d) throw new N("Invalid data-ad-layout-key value: " + f);
            f = (b + -725) / 1E3;
            e = 0;
            c = 1;
            a = d.length;
            for (g = 0; g < a; g++) e += d[g] * c, c *= f;
            f = Math.ceil(1E3 * e - -725 + 10);
            if (isNaN(f)) throw new N("Invalid height: height=" + f);
            if (50 > f) throw new N("Fluid responsive ads must be at least 50px tall: height=" + f);
            if (1200 < f) throw new N("Fluid responsive ads must be at most 1200px tall: height=" + f);
            return new Ih(11, new P(b, f))
        }
        d = ii[f];
        if (!d) throw new N("Invalid data-ad-layout value: " + f);
        d = Math.ceil(d(b));
        return new Ih(11, "in-article" == f ? new ji(b, d) : new P(b, d))
    };

    function li(a, b) {
        P.call(this, a, b)
    }

    ja(li, P);
    li.prototype.I = function () {
        return this.minWidth()
    };
    li.prototype.W = function (a) {
        return P.prototype.W.call(this, a) + "_0ads_al"
    };
    var mi = [new li(728, 15), new li(468, 15), new li(200, 90), new li(180, 90), new li(160, 90), new li(120, 90)];

    function ni(a, b, c) {
        var d = 250, e = 90;
        d = void 0 === d ? 130 : d;
        e = void 0 === e ? 30 : e;
        var f = $h(mi, xe(a));
        if (!f) throw new N("No link unit size for width=" + a + "px");
        a = Math.min(a, 1200);
        f = f.height();
        b = Math.max(f, b);
        d = (new Ih(10, new li(a, Math.min(b, 15 == f ? e : d)))).a;
        b = d.minWidth();
        d = d.height();
        15 <= c && (d = c);
        return new Ih(10, new li(b, d))
    }

    function oi(a, b, c, d) {
        if ("false" == d.google_full_width_responsive) return d.google_full_width_responsive_allowed = !1, d.gfwrnwer = 1, a;
        var e = te(a, b, c, d);
        if (!0 !== e) return d.google_full_width_responsive_allowed = !1, d.gfwrnwer = e, a;
        e = O(b);
        if (!e) return a;
        d.google_full_width_responsive_allowed = !0;
        ve(b, c, c.parentElement, a, e, d);
        return e
    };

    function pi(a, b, c, d, e) {
        var f;
        (f = O(b)) ? 488 > O(b) ? b.innerHeight >= b.innerWidth ? (e.google_full_width_responsive_allowed = !0, ve(b, c, c.parentElement, a, f, e), f = {
            j: f,
            l: !0
        }) : f = {j: a, l: 5} : f = {j: a, l: 4} : f = {j: a, l: 10};
        var g = f;
        f = g.j;
        g = g.l;
        if (!0 !== g || a == f) return new Ih(12, new P(a, d), null, null, !0, g, 100);
        a = ei(f, "auto", b, c, e, !0);
        return new Ih(1, a.H, a.Z, 2, !0, g, a.F, a.C, a.D)
    };

    function qi(a) {
        var b = a.google_ad_format;
        if ("autorelaxed" == b) {
            a:{
                if ("pedestal" != a.google_content_recommendation_ui_type) {
                    b = ba(Sh);
                    for (var c = b.next(); !c.done; c = b.next()) if (null != a[c.value]) {
                        a = !0;
                        break a
                    }
                }
                a = !1
            }
            return a ? 9 : 5
        }
        if (ci(b)) return 1;
        if ("link" == b) return 4;
        if ("fluid" == b) return 8
    }

    function ri(a, b, c, d, e) {
        e = b.offsetWidth || (c.google_ad_resize || (void 0 === e ? !1 : e)) && we(b, d, "width", F) || c.google_ad_width || 0;
        var f = I(d, Qf.f) && 4 === a, g = I(d, Sf.f) && (5 === a || 9 === a);
        if (f || g) c.google_ad_format = "auto", c.google_ad_slot = "", a = 1;
        f = (f = si(a, e, b, c, d)) ? f : di(e, c.google_ad_format, d, b, c);
        f.a.P(d, e, c, b);
        Jh(f, e, c);
        1 != a && (a = f.a.height(), b.style.height = a + "px")
    }

    function si(a, b, c, d, e) {
        var f = d.google_ad_height || we(c, e, "height", F);
        switch (a) {
            case 5:
                return a = Sd(247, function () {
                    return bi(b, d.google_ad_format, e, c, d)
                }), f = a.j, a = a.l, !0 === a && b != f && ve(e, c, c.parentElement, b, f, d), !0 === a ? d.google_full_width_responsive_allowed = !0 : (d.google_full_width_responsive_allowed = !1, d.gfwrnwer = a), ti(e) && (d.ovlp = !0), Uh(f, d);
            case 9:
                return Xh(b, d);
            case 4:
                return a = oi(b, e, c, d), ni(a, De(e, c), f);
            case 8:
                return ki(b, e, c, f, d);
            case 10:
                return pi(b, e, c, f, d)
        }
    }

    function ti(a) {
        return I(a, gg.c) || I(a, gg.f)
    };

    function W(a) {
        this.h = [];
        this.b = a || window;
        this.a = 0;
        this.g = null;
        this.i = 0
    }

    var ui;
    l = W.prototype;
    l.Ha = function (a, b) {
        0 != this.a || 0 != this.h.length || b && b != window ? this.ka(a, b) : (this.a = 2, this.ua(new vi(a, window)))
    };
    l.ka = function (a, b) {
        this.h.push(new vi(a, b || this.b));
        wi(this)
    };
    l.Pa = function (a) {
        this.a = 1;
        if (a) {
            var b = Td(188, Ca(this.ta, this, !0));
            this.g = this.b.setTimeout(b, a)
        }
    };
    l.ta = function (a) {
        a && ++this.i;
        1 == this.a && (null != this.g && (this.b.clearTimeout(this.g), this.g = null), this.a = 0);
        wi(this)
    };
    l.Va = function () {
        return !(!window || !Array)
    };
    l.Ja = function () {
        return this.i
    };

    function wi(a) {
        var b = Td(189, Ca(a.Xa, a));
        a.b.setTimeout(b, 0)
    }

    l.Xa = function () {
        if (0 == this.a && this.h.length) {
            var a = this.h.shift();
            this.a = 2;
            var b = Td(190, Ca(this.ua, this, a));
            a.a.setTimeout(b, 0);
            wi(this)
        }
    };
    l.ua = function (a) {
        this.a = 0;
        a.b()
    };

    function xi(a) {
        try {
            return a.sz()
        } catch (b) {
            return !1
        }
    }

    function yi(a) {
        return !!a && ("object" === typeof a || "function" === typeof a) && xi(a) && Dc(a.nq) && Dc(a.nqa) && Dc(a.al) && Dc(a.rl)
    }

    function zi() {
        if (ui && xi(ui)) return ui;
        var a = Ie(), b = a.google_jobrunner;
        return yi(b) ? ui = b : a.google_jobrunner = ui = new W(a)
    }

    function Ai(a, b) {
        zi().nq(a, b)
    }

    function Bi(a, b) {
        zi().nqa(a, b)
    }

    W.prototype.nq = W.prototype.Ha;
    W.prototype.nqa = W.prototype.ka;
    W.prototype.al = W.prototype.Pa;
    W.prototype.rl = W.prototype.ta;
    W.prototype.sz = W.prototype.Va;
    W.prototype.tc = W.prototype.Ja;

    function vi(a, b) {
        this.b = a;
        this.a = b
    };

    function Ci(a, b) {
        var c = Lc(b);
        if (c) {
            c = O(c);
            var d = Wb(a, b) || {}, e = d.direction;
            if ("0px" === d.width && "none" != d.cssFloat) return -1;
            if ("ltr" === e && c) return Math.floor(Math.min(1200, c - a.getBoundingClientRect().left));
            if ("rtl" === e && c) return a = b.document.body.getBoundingClientRect().right - a.getBoundingClientRect().right, Math.floor(Math.min(1200, c - a - Math.floor((c - b.document.body.clientWidth) / 2)))
        }
        return -1
    };

    function Di(a) {
        var b = this;
        this.a = a;
        a.google_iframe_oncopy || (a.google_iframe_oncopy = {
            handlers: {}, upd: function (c, d) {
                var e = Ei("rx", c), f = Number;
                a:{
                    if (c && (c = c.match("dt=([^&]+)")) && 2 == c.length) {
                        c = c[1];
                        break a
                    }
                    c = ""
                }
                f = f(c);
                f = (new Date).getTime() - f;
                e = e.replace(/&dtd=(\d+|-?M)/, "&dtd=" + (1E5 <= f ? "M" : 0 <= f ? f : "-M"));
                b.set(d, e);
                return e
            }
        });
        this.b = a.google_iframe_oncopy
    }

    Di.prototype.set = function (a, b) {
        var c = this;
        this.b.handlers[a] = b;
        this.a.addEventListener && this.a.addEventListener("load", function () {
            var d = c.a.document.getElementById(a);
            try {
                var e = d.contentWindow.document;
                if (d.onload && e && (!e.body || !e.body.firstChild)) d.onload()
            } catch (f) {
            }
        }, !1)
    };

    function Ei(a, b) {
        var c = new RegExp("\\b" + a + "=(\\d+)"), d = c.exec(b);
        d && (b = b.replace(c, a + "=" + (+d[1] + 1 || 1)));
        return b
    }

    var Fi,
        Gi = "var i=this.id,s=window.google_iframe_oncopy,H=s&&s.handlers,h=H&&H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&&d&&(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}";
    var X = Gi;
    /[\x00&<>"']/.test(X) && (-1 != X.indexOf("&") && (X = X.replace(Va, "&amp;")), -1 != X.indexOf("<") && (X = X.replace(Wa, "&lt;")), -1 != X.indexOf(">") && (X = X.replace(Xa, "&gt;")), -1 != X.indexOf('"') && (X = X.replace(Ya, "&quot;")), -1 != X.indexOf("'") && (X = X.replace(Za, "&#39;")), -1 != X.indexOf("\x00") && (X = X.replace($a, "&#0;")));
    Gi = X;
    Fi = Gi;
    var Hi = {},
        Ii = (Hi.google_ad_modifications = !0, Hi.google_analytics_domain_name = !0, Hi.google_analytics_uacct = !0, Hi.google_pause_ad_requests = !0, Hi);

    function Ji() {
        var a = p;
        this.b = a = void 0 === a ? p : a;
        this.i = "https://securepubads.g.doubleclick.net/static/3p_cookie.html";
        this.a = 2;
        this.g = [];
        this.h = !1;
        a:{
            a = Ub(!1, 50);
            var b = Sb(p);
            b && a.unshift(b);
            a.unshift(p);
            var c;
            for (b = 0; b < a.length; ++b) try {
                var d = a[b], e = Ki(d);
                if (e) {
                    this.a = Li(e);
                    if (2 != this.a) break a;
                    !c && Qb(d) && (c = d)
                }
            } catch (f) {
            }
            this.b = c || this.b
        }
    }

    function Mi(a) {
        if (2 != Ni(a)) {
            for (var b = 1 == Ni(a), c = 0; c < a.g.length; c++) try {
                a.g[c](b)
            } catch (d) {
            }
            a.g = []
        }
    }

    function Oi(a) {
        var b = Ki(a.b);
        b && 2 == a.a && (a.a = Li(b))
    }

    function Ni(a) {
        Oi(a);
        return a.a
    }

    function Pi(a) {
        var b = Qi;
        b.g.push(a);
        if (2 != b.a) Mi(b); else if (b.h || (mc(b.b, "message", function (c) {
            var d = Ki(b.b);
            if (d && c.source == d && 2 == b.a) {
                switch (c.data) {
                    case "3p_cookie_yes":
                        b.a = 1;
                        break;
                    case "3p_cookie_no":
                        b.a = 0
                }
                Mi(b)
            }
        }), b.h = !0), Ki(b.b)) Mi(b); else {
            a = Mb(new Lb(b.b.document), "IFRAME");
            a.src = b.i;
            a.name = "detect_3p_cookie";
            a.style.visibility = "hidden";
            a.style.display = "none";
            a.onload = function () {
                Oi(b);
                Mi(b)
            };
            try {
                b.b.document.body.appendChild(a)
            } catch (c) {
            }
        }
    }

    function Ki(a) {
        return a.frames && a.frames[vb("detect_3p_cookie")] || null
    }

    function Li(a) {
        return gc(a, "3p_cookie_yes") ? 1 : gc(a, "3p_cookie_no") ? 0 : 2
    };var Ri = /^\.google\.(com?\.)?[a-z]{2,3}$/, Si = /\.(cn|com\.bi|do|sl|ba|by|ma|am)$/;

    function Ti(a) {
        return Ri.test(a) && !Si.test(a)
    }

    var Ui = p, Qi;

    function Vi(a) {
        a = "https://" + ("adservice" + a + "/adsid/integrator.js");
        var b = ["domain=" + encodeURIComponent(p.location.hostname)];
        Y[3] >= +new Date && b.push("adsid=" + encodeURIComponent(Y[1]));
        return a + "?" + b.join("&")
    }

    var Y, Z;

    function Wi() {
        Ui = p;
        Y = Ui.googleToken = Ui.googleToken || {};
        var a = +new Date;
        Y[1] && Y[3] > a && 0 < Y[2] || (Y[1] = "", Y[2] = -1, Y[3] = -1, Y[4] = "", Y[6] = "");
        Z = Ui.googleIMState = Ui.googleIMState || {};
        Ti(Z[1]) || (Z[1] = ".google.com");
        "array" == ua(Z[5]) || (Z[5] = []);
        "boolean" == typeof Z[6] || (Z[6] = !1);
        "array" == ua(Z[7]) || (Z[7] = []);
        oa(Z[8]) || (Z[8] = 0)
    }

    var Xi = {
        X: function () {
            return 0 < Z[8]
        }, Ra: function () {
            Z[8]++
        }, Sa: function () {
            0 < Z[8] && Z[8]--
        }, Ta: function () {
            Z[8] = 0
        }, $a: function () {
            return !1
        }, la: function () {
            return Z[5]
        }, ia: function (a) {
            try {
                a()
            } catch (b) {
                p.setTimeout(function () {
                    throw b;
                }, 0)
            }
        }, sa: function () {
            if (!Xi.X()) {
                var a = p.document, b = function (e) {
                    e = Vi(e);
                    a:{
                        try {
                            var f = pa();
                            break a
                        } catch (g) {
                        }
                        f = void 0
                    }
                    Af(a, e, f);
                    f = a.createElement("script");
                    f.type = "text/javascript";
                    f.onerror = function () {
                        return p.processGoogleToken({}, 2)
                    };
                    e = Nb(e);
                    rb(f, e);
                    try {
                        (a.head || a.body || a.documentElement).appendChild(f), Xi.Ra()
                    } catch (g) {
                    }
                }, c = Z[1];
                b(c);
                ".google.com" != c && b(".google.com");
                b = {};
                var d = (b.newToken = "FBT", b);
                p.setTimeout(function () {
                    return p.processGoogleToken(d, 1)
                }, 1E3)
            }
        }
    };

    function Yi(a) {
        Wi();
        var b = Ui.googleToken[5] || 0;
        a && (0 != b || Y[3] >= +new Date ? Xi.ia(a) : (Xi.la().push(a), Xi.sa()));
        Y[3] >= +new Date && Y[2] >= +new Date || Xi.sa()
    }

    function Zi(a) {
        p.processGoogleToken = p.processGoogleToken || function (b, c) {
            var d = b;
            d = void 0 === d ? {} : d;
            c = void 0 === c ? 0 : c;
            b = d.newToken || "";
            var e = "NT" == b, f = parseInt(d.freshLifetimeSecs || "", 10), g = parseInt(d.validLifetimeSecs || "", 10),
                h = d["1p_jar"] || "";
            d = d.pucrd || "";
            Wi();
            1 == c ? Xi.Ta() : Xi.Sa();
            var k = Ui.googleToken = Ui.googleToken || {},
                m = 0 == c && b && r(b) && !e && oa(f) && 0 < f && oa(g) && 0 < g && r(h);
            e = e && !Xi.X() && (!(Y[3] >= +new Date) || "NT" == Y[1]);
            var n = !(Y[3] >= +new Date) && 0 != c;
            if (m || e || n) e = +new Date, f = e + 1E3 * f, g = e + 1E3 * g, 1E-5 > Math.random() && nc("https://pagead2.googlesyndication.com/pagead/gen_204?id=imerr&err=" + c, null), k[5] = c, k[1] = b, k[2] = f, k[3] = g, k[4] = h, k[6] = d, Wi();
            if (m || !Xi.X()) {
                c = Xi.la();
                for (b = 0; b < c.length; b++) Xi.ia(c[b]);
                c.length = 0
            }
        };
        Yi(a)
    }

    function $i(a) {
        Qi = Qi || new Ji;
        Pi(function (b) {
            b && a()
        })
    };var aj = vb("script");

    function bj() {
        E.google_sa_impl && !E.document.getElementById("google_shimpl") && (E.google_sa_queue = null, E.google_sl_win = null, E.google_sa_impl = null);
        if (!E.google_sa_queue) {
            E.google_sa_queue = [];
            E.google_sl_win = E;
            E.google_process_slots = function () {
                return cj(E)
            };
            var a = "/show_ads_impl.js";
            I(E, kg.f) ? a = "/show_ads_impl_es2017.js" : I(E, kg.c) && (a = "/show_ads_impl_es5.js");
            var b = dj(a);
            Af(E.document, b);
            I(E, "20199335") || !nb() || u("iPhone") && !u("iPod") && !u("iPad") || u("iPad") || u("iPod") ? Vb(E.document, b).id = "google_shimpl" : (b = document.createElement("IFRAME"), b.id = "google_shimpl", b.style.display = "none", E.document.documentElement.appendChild(b), Eh(E, "google_shimpl", "<!doctype html><html><body>" + ("<" + aj + ">") + "google_sl_win=window.parent;google_async_iframe_id='google_shimpl';" + ("</" + aj + ">") + ej(a) + "</body></html>"), b.contentWindow.document.close())
        }
    }

    var cj = Td(215, function (a) {
        var b = a.google_sa_queue, c = b.shift();
        a.google_sa_impl || Ud("shimpl", {t: "no_fn"});
        "function" == ua(c) && Sd(216, c);
        b.length && a.setTimeout(function () {
            return cj(a)
        }, 0)
    });

    function fj(a, b, c) {
        a.google_sa_queue = a.google_sa_queue || [];
        a.google_sa_impl ? c(b) : a.google_sa_queue.push(b)
    }

    function ej(a) {
        a = dj(void 0 === a ? "/show_ads_impl.js" : a);
        return "<" + aj + ' src="' + a + '"></' + aj + ">"
    }

    function dj(a) {
        a = void 0 === a ? "/show_ads_impl.js" : a;
        var b = uc ? "https" : "http";
        a:{
            if (sc) try {
                var c = E.google_cafe_host || E.top.google_cafe_host;
                if (c) {
                    var d = c;
                    break a
                }
            } catch (e) {
            }
            d = zc()
        }
        return ee(d, ["/pagead/js/", rc(), "/r20190131", a, ""].join(""), b)
    }

    function gj(a, b, c, d) {
        return function () {
            var e = !1;
            d && zi().al(3E4);
            try {
                Eh(a, b, c), e = !0
            } catch (g) {
                var f = Ie().google_jobrunner;
                yi(f) && f.rl()
            }
            e && (e = Ei("google_async_rrc", c), (new Di(a)).set(b, gj(a, b, e, !1)))
        }
    }

    function hj(a) {
        if (!Fh) a:{
            for (var b = Ub(), c = 0; c < b.length; c++) try {
                var d = b[c].frames.google_esf;
                if (d) {
                    Fh = d;
                    break a
                }
            } catch (e) {
            }
            Fh = null
        }
        if (!Fh) {
            if (/[^a-z0-9-]/.test(a)) return null;
            b = document.createElement("IFRAME");
            b.id = "google_esf";
            b.name = "google_esf";
            c = ee(qc("", "googleads.g.doubleclick.net"), ["/pagead/html/", rc(), "/r20190131/zrt_lookup.html#", encodeURIComponent("")].join(""));
            b.src = c;
            b.style.display = "none";
            b.setAttribute("data-ad-client", Bf(a));
            return b
        }
        return null
    }

    function ij(a, b, c) {
        jj(a, b, c, function (d, e, f) {
            d = d.document;
            for (var g = e.id, h = 0; !g || d.getElementById(g + "_anchor");) g = "aswift_" + h++;
            e.id = g;
            e.name = g;
            g = Number(f.google_ad_width || 0);
            h = Number(f.google_ad_height || 0);
            var k = f.ds || "";
            k && (k += k.endsWith(";") ? "" : ";");
            var m = "";
            if (!f.google_enable_single_iframe) {
                m = ["<iframe"];
                for (n in e) e.hasOwnProperty(n) && m.push(n + "=" + e[n]);
                m.push('style="' + ("left:0;position:absolute;top:0;border:0px;" + ("width:" + g + "px;") + ("height:" + h + "px;")) + '"');
                m.push("></iframe>");
                m = m.join(" ")
            }
            var n = e.id;
            var q = "";
            q = void 0 === q ? "" : q;
            g = "border:none;height:" + h + "px;margin:0;padding:0;" + ("position:relative;visibility:visible;width:" + g + "px;") + "background-color:transparent;";
            n = ['<ins id="' + (n + "_expand") + '"', ' style="display:inline-table;' + g + (void 0 === k ? "" : k) + '"', q ? ' data-ad-slot="' + q + '">' : ">", '<ins id="' + (n + "_anchor") + '" style="display:block;' + g + '">', m, "</ins></ins>"].join("");
            16 == f.google_reactive_ad_format ? (f = d.createElement("div"), f.innerHTML = n, c.appendChild(f.firstChild)) : c.innerHTML = n;
            return e.id
        })
    }

    function jj(a, b, c, d) {
        var e = b.google_ad_width, f = b.google_ad_height;
        I(a, ig.f) ? (Wd(!0), b.google_enable_single_iframe = !0) : I(a, ig.c) && Wd(!1);
        var g = {};
        null != e && (g.width = e && '"' + e + '"');
        null != f && (g.height = f && '"' + f + '"');
        g.frameborder = '"0"';
        g.marginwidth = '"0"';
        g.marginheight = '"0"';
        g.vspace = '"0"';
        g.hspace = '"0"';
        g.allowtransparency = '"true"';
        g.scrolling = '"no"';
        g.allowfullscreen = '"true"';
        g.onload = '"' + Fi + '"';
        d = d(a, g, b);
        kj(a, c, b);
        (c = hj(b.google_ad_client)) && a.document.documentElement.appendChild(c);
        c = Ea;
        e = (new Date).getTime();
        b.google_lrv = rc();
        b.google_async_iframe_id = d;
        b.google_unique_id = Fc(a);
        b.google_start_time = c;
        b.google_bpp = e > c ? e - c : 1;
        b.google_async_rrc = 0;
        a.google_sv_map = a.google_sv_map || {};
        a.google_sv_map[d] = b;
        a.google_t12n_vars = vf;
        if (b.google_enable_single_iframe) {
            var h = {pubWin: a, iframeWin: null, vars: b};
            fj(a, function () {
                a.google_sa_impl(h)
            }, a.document.getElementById(d + "_anchor") ? Ai : Bi)
        } else fj(a, gj(a, d, ["<!doctype html><html><body>", "<" + aj + ">", "google_sl_win=window.parent;google_iframe_start_time=new Date().getTime();", 'google_async_iframe_id="' + d + '";', "</" + aj + ">", "<" + aj + ">window.parent.google_sa_impl(" + ("{iframeWin: window, pubWin: window.parent, vars: " + ("window.parent['google_sv_map']['" + d + "']") + "}") + ");</" + aj + ">", "</body></html>"].join(""), !0), a.document.getElementById(d) ? Ai : Bi)
    }

    function kj(a, b, c) {
        var d = c.google_ad_output, e = c.google_ad_format, f = c.google_ad_width || 0, g = c.google_ad_height || 0;
        e || "html" != d && null != d || (e = f + "x" + g);
        d = !c.google_ad_slot || c.google_override_format || !Jb[c.google_ad_width + "x" + c.google_ad_height] && "aa" == c.google_loader_used;
        e && d ? e = e.toLowerCase() : e = "";
        c.google_ad_format = e;
        if (!oa(c.google_reactive_sra_index) || !c.google_ad_unit_key) {
            e = [c.google_ad_slot, c.google_orig_ad_format || c.google_ad_format, c.google_ad_type, c.google_orig_ad_width || c.google_ad_width, c.google_orig_ad_height || c.google_ad_height];
            d = [];
            f = 0;
            for (g = b; g && 25 > f; g = g.parentNode, ++f) 9 === g.nodeType ? d.push("") : d.push(g.id);
            (d = d.join()) && e.push(d);
            c.google_ad_unit_key = bc(e.join(":")).toString();
            var h = void 0 === h ? !1 : h;
            e = [];
            for (d = 0; b && 25 > d; ++d) {
                f = "";
                void 0 !== h && h || (f = (f = 9 !== b.nodeType && b.id) ? "/" + f : "");
                a:{
                    if (b && b.nodeName && b.parentElement) {
                        g = b.nodeName.toString().toLowerCase();
                        for (var k = b.parentElement.childNodes, m = 0, n = 0; n < k.length; ++n) {
                            var q = k[n];
                            if (q.nodeName && q.nodeName.toString().toLowerCase() === g) {
                                if (b === q) {
                                    g = "." + m;
                                    break a
                                }
                                ++m
                            }
                        }
                    }
                    g = ""
                }
                e.push((b.nodeName && b.nodeName.toString().toLowerCase()) + f + g);
                b = b.parentElement
            }
            h = e.join() + ":";
            b = [];
            if (a) try {
                var w = a.parent;
                for (e = 0; w && w !== a && 25 > e; ++e) {
                    var y = w.frames;
                    for (d = 0; d < y.length; ++d) if (a === y[d]) {
                        b.push(d);
                        break
                    }
                    a = w;
                    w = a.parent
                }
            } catch (G) {
            }
            c.google_ad_dom_fingerprint = bc(h + b.join()).toString()
        }
    }

    function lj(a, b) {
        var c = navigator;
        a && b && c && (a = a.document, b = Bf(b), /[^a-z0-9-]/.test(b) || ((c = Ua("r20160913")) && (c += "/"), Vb(a, ee("pagead2.googlesyndication.com", "/pub-config/" + c + b + ".js"))))
    };

    function mj(a, b) {
        a = a.attributes;
        for (var c = a.length, d = 0; d < c; d++) {
            var e = a[d];
            if (/data-/.test(e.name)) {
                var f = Ua(e.name.replace("data-matched-content", "google_content_recommendation").replace("data", "google").replace(/-/g, "_"));
                if (!b.hasOwnProperty(f)) {
                    e = e.value;
                    var g = {};
                    g = (g.google_reactive_ad_format = oc, g.google_allow_expandable_ads = fc, g);
                    e = g.hasOwnProperty(f) ? g[f](e, null) : e;
                    null === e || (b[f] = e)
                }
            }
        }
    }

    function nj(a) {
        if (a = Ac(a)) switch (a.data && a.data.autoFormat) {
            case "rspv":
                return 13;
            case "mcrspv":
                return 15;
            default:
                return 14
        } else return 12
    }

    function oj(a, b, c) {
        mj(a, b);
        if (c.document && c.document.body && !qi(b) && !b.google_reactive_ad_format) {
            var d = parseInt(a.style.width, 10), e = Ci(a, c);
            if (0 < e && d > e) {
                var f = parseInt(a.style.height, 10);
                d = !!Jb[d + "x" + f];
                var g = e;
                if (d) {
                    var h = Kb(e, f);
                    if (h) g = h, b.google_ad_format = h + "x" + f + "_0ads_al"; else throw new N("No slot size for availableWidth=" + e);
                }
                b.google_ad_resize = !0;
                b.google_ad_width = g;
                d || (b.google_ad_format = null, b.google_override_format = !0);
                e = g;
                a.style.width = e + "px";
                f = di(e, "auto", c, a, b);
                g = e;
                f.a.P(c, g, b, a);
                Jh(f, g, b);
                f = f.a;
                b.google_responsive_formats = null;
                f.minWidth() > e && !d && (b.google_ad_width = f.minWidth(), a.style.width = f.minWidth() + "px")
            }
        }
        d = a.offsetWidth || we(a, c, "width", F) || b.google_ad_width || 0;
        a:{
            e = Da(di, d, "auto", c, a, b, !1, !0);
            h = I(c, ag.c);
            var k = I(c, ag.f);
            f = I(c, cg.c);
            g = I(c, cg.f);
            var m = Ef(c, 11, b.google_ad_client), n = I(c, eg.f);
            var q = b.google_ad_client;
            q = null != Cf(c, void 0 === q ? "" : q);
            if (!(h || k || m || q) || !Pb() || b.google_reactive_ad_format || qi(b) || oe(a, b) || b.google_ad_resize || Kc(c) != c) d = !1; else {
                for (k = a; k; k = k.parentElement) if (m = Wb(k, c), !m || !Ka(["static", "relative"], m.position)) {
                    d = !1;
                    break a
                }
                if (!0 !== se(c, a, d, .3, b)) d = !1; else {
                    b.google_resizing_allowed = !0;
                    k = tf(c.location, "google_responsive_slot_debug");
                    m = Q(zf(), 142);
                    if (k || Math.random() < m) b.ovlp = !0;
                    h || g || n ? (h = {}, Jh(e(), d, h), b.google_resizing_width = h.google_ad_width, b.google_resizing_height = h.google_ad_height, h.ds && (b.ds = h.ds), b.iaaso = !1) : (b.google_ad_format = "auto", b.iaaso = !0, b.armr = 1);
                    (d = f ? "AutoOptimizeAdSizeVariant" : g ? "AutoOptimizeAdSizeOriginal" : null) && (b.google_ad_channel = b.google_ad_channel ? [b.google_ad_channel, d].join("+") : d);
                    d = !0
                }
            }
        }
        if (e = qi(b)) ri(e, a, b, c, d); else {
            if (oe(a, b)) {
                if (d = Wb(a, c)) a.style.width = d.width, a.style.height = d.height, ne(d, b);
                b.google_ad_width || (b.google_ad_width = a.offsetWidth);
                b.google_ad_height || (b.google_ad_height = a.offsetHeight);
                b.google_loader_features_used = 256;
                b.google_responsive_auto_format = nj(c)
            } else ne(a.style, b), 300 == b.google_ad_width && 250 == b.google_ad_height && (d = a.style.width, a.style.width = "100%", e = a.offsetWidth, a.style.width = d, b.google_available_width = e);
            c.location && "#gfwmrp" == c.location.hash || 12 == b.google_responsive_auto_format && "true" == b.google_full_width_responsive && !I(c, Mf.f) ? ri(10, a, b, c, !1) : I(c, Nf.f) && 12 == b.google_responsive_auto_format && (a = te(a.offsetWidth || parseInt(a.style.width, 10) || b.google_ad_width, c, a, b), !0 !== a ? (b.efwr = !1, b.gfwrnwer = a) : b.efwr = !0)
        }
    };

    function pj(a) {
        return Jc.test(a.className) && "done" != a.getAttribute("data-adsbygoogle-status")
    }

    function qj(a, b) {
        var c = window;
        a.setAttribute("data-adsbygoogle-status", "done");
        rj(a, b, c)
    }

    function rj(a, b, c) {
        var d = Ic();
        d.google_spfd || (d.google_spfd = oj);
        (d = b.google_reactive_ads_config) || oj(a, b, c);
        if (!sj(a, b, c)) {
            d || (c.google_lpabyc = ng(c, a));
            if (d) {
                if (H(E).page_contains_reactive_tag) {
                    if (d.page_level_pubvars && d.page_level_pubvars.pltais) return;
                    throw new N("Only one 'enable_page_level_ads' allowed per page.");
                }
                H(E).page_contains_reactive_tag = !0
            } else Ec(c);
            H(E).per_pub_js_loaded || (H(E).per_pub_js_loaded = !0, lj(c, b.google_ad_client));
            Cc(Ii, function (e, f) {
                b[f] = b[f] || c[f]
            });
            b.google_loader_used = "aa";
            b.google_reactive_tag_first = 1 === (H(E).first_tag_on_page || 0);
            Sd(164, function () {
                ij(c, b, a)
            })
        }
    }

    function sj(a, b, c) {
        var d = b.google_reactive_ads_config;
        if (d) {
            var e = d.page_level_pubvars;
            e = (wa(e) ? e : {}).google_tag_origin
        }
        var f = e || b.google_tag_origin;
        e = r(a.className) && /(\W|^)adsbygoogle-noablate(\W|$)/.test(a.className);
        var g = c.google_bfabyc;
        c.google_pbfabyc && !b.ebfa ? b.ebfaca = !0 : g && !b.google_bfa && (b.ebfaca = !0);
        var h = b.google_ad_slot;
        g = H(c);
        Nc(g.ad_whitelist || [], h, f) ? g = null : (f = g.space_collapsing || "none", g = (h = Nc(g.ad_blacklist || [], h)) ? {
            ga: !0,
            wa: h.space_collapsing || f
        } : g.remove_ads_by_default ? {ga: !0, wa: f, Ga: g.dont_remove_atf} : null);
        if (e = g && g.ga && "on" != b.google_adtest && !e) {
            a:{
                try {
                    if (a.parentNode && 0 < a.offsetWidth && 0 < a.offsetHeight && a.style && "none" !== a.style.display && "hidden" !== a.style.visibility && (!a.style.opacity || 0 !== Number(a.style.opacity))) {
                        var k = a.getBoundingClientRect();
                        var m = 0 < k.right && 0 < k.bottom;
                        break a
                    }
                } catch (n) {
                }
                m = !1
            }
            m && (m = pe(a, c) < me(c).clientHeight);
            e = !(m && g.Ga)
        }
        if (e) return a.className += " adsbygoogle-ablated-ad-slot", c = c.google_sv_map = c.google_sv_map || {}, b.google_ad_slot && (c[b.google_ad_slot] = b, a.setAttribute("google_ad_slot", b.google_ad_slot)), "slot" == g.wa && (null !== ec(a.getAttribute("width")) && a.setAttribute("width", 0), null !== ec(a.getAttribute("height")) && a.setAttribute("height", 0), a.style.width = "0px", a.style.height = "0px"), !0;
        if ((m = Wb(a, c)) && "none" == m.display && !("on" == b.google_adtest || 0 < b.google_reactive_ad_format || d)) return c.document.createComment && a.appendChild(c.document.createComment("No ad requested because of display:none on the adsbygoogle tag")), !0;
        a = null == b.google_pgb_reactive || 3 === b.google_pgb_reactive;
        return 1 !== b.google_reactive_ad_format && 8 !== b.google_reactive_ad_format || !a ? !1 : (p.console && p.console.warn("Adsbygoogle tag with data-reactive-ad-format=" + b.google_reactive_ad_format + " is deprecated. Check out page-level ads at https://www.google.com/adsense"), !0)
    }

    function tj(a) {
        var b = document.getElementsByTagName("INS");
        for (var c = 0, d = b[c]; c < b.length; d = b[++c]) {
            var e = d;
            if (pj(e) && "reserved" != e.getAttribute("data-adsbygoogle-status") && (!a || d.id == a)) return d
        }
        return null
    }

    function uj() {
        var a = document.createElement("INS");
        a.className = "adsbygoogle";
        a.className += " adsbygoogle-noablate";
        hc(a);
        return a
    }

    function vj(a) {
        var b = {};
        Cc(Oc, function (e, f) {
            !1 === a.enable_page_level_ads ? b[f] = !1 : a.hasOwnProperty(f) && (b[f] = a[f])
        });
        wa(a.enable_page_level_ads) && (b.page_level_pubvars = a.enable_page_level_ads);
        var c = uj();
        Ib.body.appendChild(c);
        var d = {};
        d = (d.google_reactive_ads_config = b, d.google_ad_client = a.google_ad_client, d);
        d.google_pause_ad_requests = H(E).pause_ad_requests || !1;
        qj(c, d)
    }

    function wj(a) {
        return "complete" == a.readyState || "interactive" == a.readyState
    }

    function xj(a) {
        function b() {
            return vj(a)
        }

        var c = void 0 === c ? Ib : c;
        var d = Lc(window);
        if (!d) throw new N("Page-level tag does not work inside iframes.");
        le(d).wasPlaTagProcessed = !0;
        if (c.body || wj(c)) b(); else {
            var e = Na(Md(191, b));
            mc(c, "DOMContentLoaded", e);
            Cc(H(E).eids || [], function (f) {
                switch (f) {
                    case jg.Ca:
                        var g = p.setInterval(function () {
                            c.body && (e(), p.clearInterval(g))
                        }, 100);
                        break;
                    case jg.R:
                        p.MutationObserver && (new p.MutationObserver(function (h, k) {
                            c.body && (e(), k.disconnect())
                        })).observe(c, {childList: !0, subtree: !0})
                }
            })
        }
    }

    function yj(a) {
        var b = {};
        Sd(165, function () {
            zj(a, b)
        }, function (c) {
            c.client = c.client || b.google_ad_client || a.google_ad_client;
            c.slotname = c.slotname || b.google_ad_slot;
            c.tag_origin = c.tag_origin || b.google_tag_origin
        })
    }

    var Aj, Bj = {
        google_ad_client: !0,
        google_ad_host: !0,
        google_adtest: !0,
        google_tag_for_child_directed_treatment: !0,
        google_tag_for_under_age_of_consent: !0,
        google_tag_partner: !0
    }, Cj = Bj;
    Object.isFrozen && !Object.isFrozen(Bj) && (Cj = Object.create(Bj), Object.freeze(Cj));
    Aj = Cj;

    function Dj(a) {
        delete a.google_checked_head;
        ac(a, function (b, c) {
            Aj[c] || (delete a[c], b = c.replace("google", "data").replace(/_/g, "-"), p.console.warn("AdSense head tag doesn't support " + b + " attribute."))
        })
    }

    function zj(a, b) {
        Ea = (new Date).getTime();
        bj();
        a:{
            if (void 0 != a.enable_page_level_ads) {
                if (r(a.google_ad_client)) {
                    var c = !0;
                    break a
                }
                throw new N("'google_ad_client' is missing from the tag config.");
            }
            c = !1
        }
        if (c) Ej(a, b); else if ((c = a.params) && Cc(c, function (e, f) {
            b[f] = e
        }), "js" === b.google_ad_output) console.warn("Ads with google_ad_output='js' have been deprecated and no longer work. Contact your AdSense account manager or switch to standard AdSense ads."); else {
            a = Fj(a.element);
            mj(a, b);
            c = H(p).head_tag_slot_vars || {};
            ac(c, function (e, f) {
                b.hasOwnProperty(f) || (b[f] = e)
            });
            if (a.hasAttribute("data-require-head") && !H(p).head_tag_slot_vars) throw new N("AdSense head tag is missing. AdSense body tags don't work without the head tag. You can copy the head tag from your account on https://adsense.com.");
            var d = (c = 0 === (H(E).first_tag_on_page || 0) && lg(b)) && mg(c);
            c && !d && (Ej(c), H(E).skip_next_reactive_tag = !0);
            0 === (H(E).first_tag_on_page || 0) && (H(E).first_tag_on_page = 2);
            b.google_pause_ad_requests = H(E).pause_ad_requests || !1;
            qj(a, b);
            c && d && Gj(c)
        }
    }

    function Gj(a) {
        function b() {
            le(p).wasPlaTagProcessed || p.adsbygoogle && p.adsbygoogle.push(a)
        }

        wj(Ib) ? b() : mc(Ib, "DOMContentLoaded", Na(b))
    }

    function Ej(a, b) {
        if (H(E).skip_next_reactive_tag) H(E).skip_next_reactive_tag = !1; else {
            0 === (H(E).first_tag_on_page || 0) && (H(E).first_tag_on_page = 1);
            b && a.tag_partner && (Mc(p, a.tag_partner), Mc(b, a.tag_partner));
            a:if (!H(E).ama_ran_on_page) {
                H(E).ama_ran_on_page = !0;
                try {
                    var c = p.localStorage.getItem("google_ama_config")
                } catch (y) {
                    c = null
                }
                try {
                    var d = c ? new $c(c ? JSON.parse(c) : null) : null
                } catch (y) {
                    d = null
                }
                if (b = d) if (c = C(b, bd, 3), !c || z(c, 1) <= +new Date) try {
                    p.localStorage.removeItem("google_ama_config")
                } catch (y) {
                    ce(p, {lserr: 1})
                } else {
                    if (mg(a) && (c = gd(p.location.pathname, D(b, cd, 7)), !c || !Ab(c, 8))) break a;
                    if (C(b, fd, 13)) switch (c = !0, z(C(b, fd, 13), 1)) {
                        case 1:
                        case 2:
                        case 3:
                            c = !1;
                        case 4:
                        case 5:
                        case 6:
                            c = void 0 === c ? !1 : c, d = H(p), d.remove_ads_by_default = !0, d.space_collapsing = "slot", d.dont_remove_atf = c
                    }
                    he(3, [Eb(b)]);
                    c = a.google_ad_client;
                    d = Yd($d, new Xd(null, de(wa(a.enable_page_level_ads) ? a.enable_page_level_ads : {})));
                    try {
                        var e = gd(p.location.pathname, D(b, cd, 7)), f;
                        if (f = e) b:{
                            var g = z(e, 2);
                            if (g) for (var h = 0; h < g.length; h++) if (1 == g[h]) {
                                f = !0;
                                break b
                            }
                            f = !1
                        }
                        if (f) {
                            if (z(e, 4)) {
                                f = {};
                                var k = new Xd(null, (f.google_package = z(e, 4), f));
                                d = Yd(d, k)
                            }
                            var m = new ff(c, b, e, d), n = new jf;
                            (new of(m, n)).start();
                            var q = n.b;
                            var w = Da(rf, p);
                            if (q.b) throw Error("Then functions already set.");
                            q.b = Da(qf, p);
                            q.g = w;
                            mf(q)
                        }
                    } catch (y) {
                        ce(p, {atf: -1})
                    }
                }
            }
            xj(a)
        }
    }

    function Fj(a) {
        if (a) {
            if (!pj(a) && (a.id ? a = tj(a.id) : a = null, !a)) throw new N("'element' has already been filled.");
            if (!("innerHTML" in a)) throw new N("'element' is not a good DOM element.");
        } else if (a = tj(), !a) throw new N("All ins elements in the DOM with class=adsbygoogle already have ads in them.");
        return a
    }

    function Hj() {
        Pd();
        Nd.w = Vd;
        Sd(166, Ij)
    }

    function Ij() {
        var a = Bc(Ac(E)) || E, b = H(a);
        if (!b.plle) {
            b.plle = !0;
            var c = sh.u();
            lh(c, 5);
            b.eids = Ha(c.h, String).concat(b.eids || []);
            b = b.eids;
            c = zf();
            var d = zf();
            var e = Lc(a) || a;
            e = tf(e.location, "google_responsive_slot_debug") || tf(e.location, "google_responsive_slot_preview");
            var f = Ef(a, 11), g = null != Cf(a, "");
            e ? (e = ag, f = bg, d = e.f) : g ? (e = eg, f = fg, d = T(a, new M(0, 999, ""), Q(d, 152), Q(d, 153), [e.c, e.f], 2)) : f ? (e = cg, f = dg, d = T(a, new M(0, 999, ""), Q(d, 120), Q(d, 121), [e.c, e.f], 2)) : (e = ag, f = bg, d = T(a, yh, Q(d, 96), Q(d, 97), [e.c, e.f]));
            d ? (g = {}, e = (g[e.c] = f.c, g[e.f] = f.f, g)[d], d = {Oa: d, Qa: e}) : d = null;
            e = d || {};
            d = e.Oa;
            e = e.Qa;
            d && e && (R(b, d), R(b, e));
            f = Mf;
            d = S(a, Q(c, 136), [f.c, f.f]);
            R(b, d);
            Ef(a, 12) && (f = Hf, g = Gf, d = T(a, new M(0, 999, ""), Q(c, 149), Q(c, 150), [f.c, f.f], 4), R(b, d), d == f.c ? e = g.c : d == f.f ? e = g.f : e = "", R(b, e));
            f = Lf;
            d = T(a, uh, Q(c, 160), Q(c, 161), [f.c, f.M, f.L]);
            R(b, d);
            g = Kf;
            d == f.c ? e = g.c : d == f.M ? e = g.M : d == f.L ? e = g.L : e = "";
            R(b, e);
            f = Uf;
            R(b, T(a, vh, Q(c, 9), Q(c, 10), [f.c, f.Ba]));
            f = Jf;
            d = T(a, Bh, Q(c, 179), Q(c, 180), [f.c, f.f]);
            R(b, d);
            g = If;
            d == f.c ? e = g.c : d == f.f ? e = g.f : e = "";
            R(b, e);
            Ua("") && R(b, "");
            f = Vf;
            d = S(a, Q(c, 13), [f.m, f.c]);
            R(b, d);
            d = S(a, 0, [f.ca]);
            R(b, d);
            f = Wf;
            d = S(a, Q(c, 60), [f.m, f.c]);
            R(b, d);
            d == Wf.m && (f = Xf, d = S(a, Q(c, 66), [f.m, f.c]), R(b, d), f = Zf, d = S(a, Q(c, 137), [f.m, f.c]), R(b, d), d == Xf.m && (f = Yf, d = S(a, Q(c, 135), [f.m, f.c]), R(b, d)));
            f = Nf;
            d = S(a, Q(c, 98), [f.c, f.f]);
            R(b, d);
            f = $f;
            d = S(a, Q(c, 76), [f.c, f.fa, f.T, f.ea]);
            R(b, d);
            d || (d = S(a, Q(c, 83), [f.da]), R(b, d));
            f = Of;
            d = T(a, Ah, Q(c, 157), Q(c, 158), [f.c, f.B]);
            R(b, d);
            g = Pf;
            d == f.c ? e = g.c : d == f.B ? e = g.B : e = "";
            R(b, e);
            f = Qf;
            d = T(a, th, Q(c, 166), Q(c, 167), [f.c, f.f]);
            R(b, d);
            g = Rf;
            d == f.c ? e = g.c : d == f.f ? e = g.f : e = "";
            R(b, e);
            f = Sf;
            d = T(a, zh, Q(c, 173), Q(c, 174), [f.c, f.f]);
            R(b, d);
            g = Tf;
            d == f.c ? e = g.c : d == f.f ? e = g.f : e = "";
            R(b, e);
            f = gg;
            d = T(a, xh, Q(c, 99), Q(c, 100), [f.c, f.f]);
            R(b, d);
            g = hg;
            d == f.c ? e = g.c : d == f.f ? e = g.f : e = "";
            R(b, e);
            f = ig;
            d = S(a, Q(c, 165), [f.c, f.f]);
            R(b, d);
            f = jg;
            d = T(a, wh, Q(c, 169), Q(c, 170), [f.c, f.R]);
            R(b, d);
            if (!Ib.body) switch (d) {
                case f.c:
                    R(b, "21062911");
                    break;
                case f.Ca:
                    R(b, "21062912");
                    break;
                case f.R:
                    R(b, "21062913")
            }
            d = S(a, Q(c, 181), ["20040081"]);
            R(b, d);
            if (nb() && qb(72) || u("Edge") && qb(16) || (u("Firefox") || u("FxiOS")) && qb(65) || u("Safari") && !(nb() || u("Coast") || u("Opera") || u("Edge") || u("Firefox") || u("FxiOS") || u("Silk") || u("Android")) && qb(12)) f = kg, d = T(a, Ch, Q(c, 183), Q(c, 184), [f.c, f.f]), R(b, d);
            d = S(a, Q(c, 185), ["20199336", "20199335"]);
            R(b, d);
            a = Lc(a) || a;
            tf(a.location, "google_mc_lab") && R(b, "242104166")
        }
        if (!I(E, "20040081") || !u("Trident") && !u("MSIE") || qb(11)) {
            a = I(E, Xf.m) || I(E, Vf.m) || I(E, Vf.ca);
            Od(a);
            if (I(E, $f.fa) || I(E, $f.T) || I(E, $f.ea) || I(E, $f.da)) Wi(), Ti(".google.cn") && (Z[1] = ".google.cn"), I(E, $f.T) ? (a = Na(sa), $i(a), Zi(a)) : Zi(null);
            if (a = Lc(p)) a = le(a), a.tagSpecificState[1] || (a.tagSpecificState[1] = new sf);
            if (c = E.document.querySelector('script[src*="/pagead/js/adsbygoogle.js"][data-ad-client]:not([data-checked-head])')) {
                c.setAttribute("data-checked-head", "true");
                b = H(window);
                if (b.head_tag_slot_vars) throw new N("Only one AdSense head tag supported per page. The second tag is ignored.");
                a = {};
                mj(c, a);
                Dj(a);
                c = {};
                for (var h in a) c[h] = a[h];
                b.head_tag_slot_vars = c;
                h = {};
                h = (h.google_ad_client = a.google_ad_client, h.enable_page_level_ads = a, h);
                E.adsbygoogle || (E.adsbygoogle = []);
                a = E.adsbygoogle;
                a.loaded ? a.push(h) : a.splice(0, 0, h)
            }
            h = window.adsbygoogle;
            if (!h || !h.loaded) {
                a = {push: yj, loaded: !0};
                try {
                    Object.defineProperty(a, "requestNonPersonalizedAds", {set: Jj}), Object.defineProperty(a, "pauseAdRequests", {set: Kj}), Object.defineProperty(a, "onload", {set: Lj})
                } catch (m) {
                }
                h && (void 0 !== h.requestNonPersonalizedAds && (a.requestNonPersonalizedAds = h.requestNonPersonalizedAds), void 0 !== h.pauseAdRequests && (a.pauseAdRequests = h.pauseAdRequests));
                if (h && h.shift) try {
                    var k;
                    for (b = 20; 0 < h.length && (k = h.shift()) && 0 < b;) yj(k), --b
                } catch (m) {
                    throw window.setTimeout(Hj, 0), m;
                }
                window.adsbygoogle = a;
                h && (a.onload = h.onload)
            }
        }
    }

    function Jj(a) {
        if (+a) {
            if ((a = Tb()) && a.frames && !a.frames.GoogleSetNPA) try {
                var b = a.document, c = new Lb(b), d = b.body || b.head && b.head.parentElement;
                if (d) {
                    var e = Mb(c, "IFRAME");
                    e.name = "GoogleSetNPA";
                    e.id = "GoogleSetNPA";
                    e.setAttribute("style", "display:none;position:fixed;left:-999px;top:-999px;width:0px;height:0px;");
                    d.appendChild(e)
                }
            } catch (f) {
            }
        } else (b = Tb().document.getElementById("GoogleSetNPA")) && b.parentNode && b.parentNode.removeChild(b)
    }

    function Kj(a) {
        +a ? H(E).pause_ad_requests = !0 : (H(E).pause_ad_requests = !1, a = function () {
            if (!H(E).pause_ad_requests) {
                var b = Ic(), c = Ic();
                try {
                    if (Ib.createEvent) {
                        var d = Ib.createEvent("CustomEvent");
                        d.initCustomEvent("adsbygoogle-pub-unpause-ad-requests-event", !1, !1, "");
                        b.dispatchEvent(d)
                    } else if (Dc(c.CustomEvent)) {
                        var e = new c.CustomEvent("adsbygoogle-pub-unpause-ad-requests-event", {
                            bubbles: !1,
                            cancelable: !1,
                            detail: ""
                        });
                        b.dispatchEvent(e)
                    } else if (Dc(c.Event)) {
                        var f = new Event("adsbygoogle-pub-unpause-ad-requests-event", {bubbles: !1, cancelable: !1});
                        b.dispatchEvent(f)
                    }
                } catch (g) {
                }
            }
        }, p.setTimeout(a, 0), p.setTimeout(a, 1E3))
    }

    function Lj(a) {
        Dc(a) && window.setTimeout(a, 0)
    };Hj();
}).call(this);
