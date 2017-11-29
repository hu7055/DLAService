$(function() {

    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2010 Q1',
            A: 2666,
            B: null,
            C: 2647
        }, {
            period: '2010 Q2',
            A: 2778,
            B: 2294,
            C: 2441
        }, {
            period: '2010 Q3',
            A: 4912,
            B: 1969,
            C: 2501
        }, {
            period: '2010 Q4',
            A: 3767,
            B: 3597,
            C: 5689
        }, {
            period: '2011 Q1',
            A: 6810,
            B: 1914,
            C: 2293
        }, {
            period: '2011 Q2',
            A: 5670,
            B: 4293,
            C: 1881
        }, {
            period: '2011 Q3',
            A: 4820,
            B: 3795,
            C: 1588
        }, {
            period: '2011 Q4',
            A: 15073,
            B: 5967,
            C: 5175
        }, {
            period: '2012 Q1',
            A: 10687,
            B: 4460,
            C: 2028
        }, {
            period: '2012 Q2',
            A: 8432,
            B: 5713,
            C: 1791
        }],
        xkey: 'period',
        ykeys: ['A', 'B', 'C'],
        labels: ['A', 'B', 'C'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });

    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "New",
            value: 12
        }, {
            label: "In Progress",
            value: 30
        }, {
            label: "Pending",
            value: 20
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });
    
});
