export default {
    title: 'Banking System',
    description: 'A banking system management backend written in spring boot by Jotter Kain - A school project',
    cleanUrls: 'without-subfolders',
    siteTitle: 'Banking System',
    lastUpdated: true,
    themeConfig: {
        footer: {
            message: 'Released under the MIT License.',
            copyright: 'Copyright © 2023-present Jotter Kain'
        },
        socialLinks: [
            { icon: 'github', link: 'https://github.com/jotterkain/finance/tree/main/backend' }
        ],
        nav: [
            {text: 'Get Started', link: '/guide/'},
            {text: 'Changelog', link: 'https://github.com/jotterkain/finance'}
        ],
        logo: "/bs.png",
        sidebar: sideBar(),
    }
}

function sideBar() {
    return {
        '/guide/': [
            {
                text: 'Get Started',
                items: [
                    {text:"Introduction",link: "/guide/"}
                ]
            },
            {
                text: 'Documentation',
                collapsible: true,
                collapsed: false,
                items: [
                    {
                        text: "Endpoints",
                        items: [
                            {text: "Customers", link: "/guide/endpoints/customers"},
                            {text: "Accounts", link: "/guide/endpoints/accounts"},
                            {text: "Actions", link: "/guide/endpoints/actions"}
                        ]
                    },
                    {text: "Errors", link: "/guide/errors/"},
                    {
                        text: "Clients",
                        items: [
                            {text: "NodeJs", link: "/guide/clients/nodejs"},
                            {text: "Dart", link: "/guide/clients/dart"},
                            {text: "PHP", link: "/guide/clients/php"},
                            {text: "JAVA", link: "/guide/clients/java"},
                        ]
                    },
                    {text: "Developers", link: "/guide/developers/"}
                ]
            }
        ]
    }

}
