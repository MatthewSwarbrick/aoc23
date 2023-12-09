val sample = listOf(
    "0 3 6 9 12 15",
    "1 3 6 10 15 21",
    "10 13 16 21 30 45"
)

val input = listOf(
    "10 19 48 117 252 484 864 1510 2714 5159 10327 21218 43546 87630 171255 323839 592306 1049131 1803090 3013315 4907320",
    "0 8 23 48 87 158 319 719 1693 3921 8672 18170 36176 69017 127564 231137 415086 744974 1342005 2426756 4391573",
    "6 31 84 186 360 633 1041 1635 2492 3748 5694 9022 15400 28736 57829 121699 259874 551469 1149248 2338298 4633808",
    "28 45 72 120 210 380 695 1261 2244 3895 6582 10830 17370 27198 41645 62459 91900 132849 188932 264660 365586",
    "18 36 69 122 200 308 451 634 862 1140 1473 1866 2324 2852 3455 4138 4906 5764 6717 7770 8928",
    "4 3 0 -9 -27 -42 5 273 1100 3132 7576 16746 35225 72193 145785 290758 571276 1101281 2075720 3816857 6841029",
    "18 31 51 78 112 153 201 256 318 387 463 546 636 733 837 948 1066 1191 1323 1462 1608",
    "16 29 42 55 68 81 94 107 120 133 146 159 172 185 198 211 224 237 250 263 276",
    "20 23 22 17 8 -5 -22 -43 -68 -97 -130 -167 -208 -253 -302 -355 -412 -473 -538 -607 -680",
    "17 34 64 123 239 456 841 1512 2719 5024 9640 19003 37665 73610 140109 258244 460245 793798 1327496 2157619 3416443",
    "12 33 68 117 180 257 348 453 572 705 852 1013 1188 1377 1580 1797 2028 2273 2532 2805 3092",
    "0 3 28 102 261 555 1068 1960 3537 6351 11332 19983 34794 60401 106925 198906 397205 848689 1891968 4271333 9553412",
    "3 1 -1 6 53 212 627 1572 3569 7635 15788 32042 64296 127850 251916 491730 951275 1826245 3485613 6626310 12564587",
    "6 16 30 46 59 61 41 -15 -124 -306 -584 -984 -1535 -2269 -3221 -4429 -5934 -7780 -10014 -12686 -15849",
    "10 20 30 40 50 60 70 80 90 100 110 120 130 140 150 160 170 180 190 200 210",
    "8 15 49 124 253 448 720 1079 1534 2093 2763 3550 4459 5494 6658 7953 9380 10939 12629 14448 16393",
    "24 44 82 154 279 478 773 1192 1796 2756 4525 8194 16262 34463 76360 174898 410430 975456 2316946 5435430 12489295",
    "13 25 31 24 0 -20 47 398 1411 3727 8347 16744 30990 53898 89179 141614 217241 323557 469735 666856 928156",
    "25 40 64 103 171 314 656 1469 3276 7018 14364 28345 54714 104915 202577 397610 796343 1624596 3356248 6967667 14425657",
    "15 37 74 143 270 493 878 1568 2909 5738 11995 25975 56843 123619 264883 557196 1148983 2320719 4588048 8872255 16772496",
    "10 26 64 141 291 575 1087 1963 3419 5870 10210 18357 34187 65013 123854 232975 429716 776706 1380528 2426253 4240655",
    "16 38 83 165 303 539 980 1886 3854 8186 17574 37298 77259 155477 304439 583411 1103492 2079422 3935589 7517347 14498615",
    "30 40 58 105 210 410 750 1283 2070 3180 4690 6685 9258 12510 16550 21495 27470 34608 43050 52945 64450",
    "5 11 28 60 103 137 116 -42 -451 -1191 -2055 -1833 3409 24029 84121 235029 578989 1308631 2770450 5563414 10687739",
    "10 10 12 20 52 159 465 1238 3007 6752 14213 28390 54339 100409 180112 314872 537960 899990 1476426 2377632 3762086",
    "3 14 38 81 155 278 474 773 1211 1830 2678 3809 5283 7166 9530 12453 16019 20318 25446 31505 38603",
    "10 30 68 146 312 650 1283 2377 4175 7122 12185 21526 39751 76034 147502 284365 537384 988390 1764698 3058402 5151690",
    "2 0 -2 7 58 220 637 1600 3680 7971 16539 33268 65487 127142 244985 470494 902298 1727134 3292288 6229665 11661820",
    "27 56 111 199 337 567 971 1686 2919 4962 8207 13161 20461 30889 45387 65072 91251 125436 169359 224987 294537",
    "12 18 44 109 238 477 928 1806 3511 6691 12251 21250 34643 52896 75665 102029 132254 172800 247334 417955 822756",
    "-2 -2 0 8 32 88 198 390 698 1162 1828 2748 3980 5588 7642 10218 13398 17270 21928 27472 34008",
    "4 9 14 19 24 29 34 39 44 49 54 59 64 69 74 79 84 89 94 99 104",
    "19 35 77 159 292 481 722 999 1281 1519 1643 1559 1146 253 -1304 -3745 -7329 -12357 -19175 -28177 -39808",
    "-2 10 29 49 61 65 101 311 1046 3027 7562 16821 34186 64725 115879 198474 328130 526964 825071 1260477 1874911",
    "14 26 39 44 36 23 35 133 418 1040 2207 4194 7352 12117 19019 28691 41878 59446 82391 111848 149100",
    "13 26 51 106 237 541 1213 2647 5646 11829 24368 49261 97478 188549 356562 660237 1200043 2147917 3800483 6677639 11710391",
    "12 20 41 96 220 462 885 1566 2596 4080 6137 8900 12516 17146 22965 30162 38940 49516 62121 77000 94412",
    "-3 2 23 66 149 326 717 1554 3268 6657 13190 25517 48270 89255 161150 283839 487527 816796 1335777 2134628 3337523",
    "14 31 67 144 293 549 958 1605 2668 4502 7774 13731 24832 46287 89644 180640 375366 791789 1668377 3468730 7061723",
    "17 28 49 97 215 499 1148 2562 5530 11571 23518 46470 89282 166820 303279 536949 926919 1562334 2574967 4156039 6578417",
    "13 23 26 28 50 139 390 987 2269 4831 9690 18588 34572 63108 114249 207063 379269 709083 1364902 2715436 5564230",
    "24 36 60 121 270 598 1263 2542 4920 9228 16842 29955 51934 87774 144661 232656 365512 561636 845208 1247469 1808190",
    "-9 1 25 73 166 336 626 1090 1793 2811 4231 6151 8680 11938 16056 21176 27451 35045 44133 54901 67546",
    "16 23 41 88 194 405 787 1430 2452 4003 6269 9476 13894 19841 27687 37858 50840 67183 87505 112496 142922",
    "9 18 35 59 84 103 123 197 480 1314 3341 7650 16045 31818 62195 125353 268299 608014 1418583 3303577 7518394",
    "14 20 38 84 175 343 669 1350 2831 6066 13019 27588 57255 115983 229322 443684 844158 1591078 2999194 5713466 11098585",
    "1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31 33 35 37 39 41",
    "17 17 20 34 67 127 222 360 549 797 1112 1502 1975 2539 3202 3972 4857 5865 7004 8282 9707",
    "4 20 57 125 242 439 765 1292 2120 3382 5249 7935 11702 16865 23797 32934 44780 59912 78985 102737 131994",
    "10 18 34 69 134 240 398 619 914 1294 1770 2353 3054 3884 4854 5975 7258 8714 10354 12189 14230",
    "0 5 26 84 225 539 1187 2440 4734 8745 15488 26444 43719 70239 109985 168272 252076 370413 534774 759620 1062941",
    "-6 -9 -2 39 150 379 786 1443 2434 3855 5814 8431 11838 16179 21610 28299 36426 46183 57774 71415 87334",
    "6 25 52 97 186 378 797 1690 3539 7288 14804 29783 59447 117565 229579 440934 830108 1528323 2748500 4826709 8280168",
    "-5 2 19 46 83 130 187 254 331 418 515 622 739 866 1003 1150 1307 1474 1651 1838 2035",
    "25 40 58 79 103 130 160 193 229 268 310 355 403 454 508 565 625 688 754 823 895",
    "5 4 11 38 92 178 315 567 1087 2170 4314 8299 15316 27214 46986 79688 134081 225408 379869 641540 1082700",
    "8 17 44 112 257 521 951 1611 2609 4138 6542 10479 17442 31374 63155 141815 340198 829729 1991076 4628636 10373599",
    "5 17 35 58 96 184 413 999 2431 5776 13277 29463 63102 130473 260615 503434 941817 1709219 3014559 5176688 8671180",
    "12 35 74 136 228 357 530 754 1036 1383 1802 2300 2884 3561 4338 5222 6220 7339 8586 9968 11492",
    "13 32 56 82 101 95 34 -127 -451 -1022 -1948 -3364 -5435 -8359 -12370 -17741 -24787 -33868 -45392 -59818 -77659",
    "24 41 66 118 224 410 693 1075 1531 1967 2096 1142 -2737 -13333 -37252 -83523 -158822 -251695 -293294 -72898 927298",
    "-3 -12 -24 -26 1 89 311 836 2022 4582 9910 20747 42538 86181 173637 349565 705773 1432706 2926742 6009374 12363649",
    "18 22 22 13 -5 -14 43 296 1000 2610 5884 12019 22825 40942 70105 115462 183950 284734 429714 634105 917095",
    "25 30 34 41 55 80 120 179 261 370 510 685 899 1156 1460 1815 2225 2694 3226 3825 4495",
    "8 9 19 48 110 223 409 694 1108 1685 2463 3484 4794 6443 8485 10978 13984 17569 21803 26760 32518",
    "-2 4 29 85 183 343 624 1180 2350 4801 9779 19619 38882 76922 153488 310361 634354 1300770 2652361 5338029 10549469",
    "15 23 30 35 30 -3 -95 -293 -663 -1293 -2296 -3813 -6016 -9111 -13341 -18989 -26381 -35889 -47934 -62989 -81582",
    "10 17 22 25 25 20 7 -18 -60 -125 -220 -353 -533 -770 -1075 -1460 -1938 -2523 -3230 -4075 -5075",
    "28 46 71 102 145 220 375 714 1453 3037 6382 13349 27612 56149 111664 216339 407418 745240 1324465 2289376 3854291",
    "18 26 43 76 142 280 557 1067 1936 3370 5830 10515 20522 43386 96252 215778 476110 1020018 2110661 4214598 8130734",
    "11 21 40 63 86 123 236 587 1546 3936 9583 22495 51259 113670 245253 514281 1047213 2070271 3975250 7420727 13483732",
    "0 17 43 82 157 320 669 1385 2804 5545 10739 20467 38645 72826 137765 262162 500816 955553 1809803 3383672 6218869",
    "3 7 14 34 89 213 459 918 1747 3198 5641 9577 15626 24416 36133 49127 56271 36553 -62604 -359876 -1103589",
    "19 47 86 142 235 412 779 1566 3252 6810 14189 29230 59310 118111 230004 436600 806025 1445393 2516744 4256342 6996645",
    "-7 -12 -17 -22 -27 -32 -37 -42 -47 -52 -57 -62 -67 -72 -77 -82 -87 -92 -97 -102 -107",
    "0 9 29 70 158 339 690 1350 2585 4902 9228 17171 31381 56030 97431 164817 271302 435047 680655 1040820 1558256",
    "14 25 39 56 76 99 125 154 186 221 259 300 344 391 441 494 550 609 671 736 804",
    "-1 2 15 39 72 104 113 70 -34 -112 213 2089 8571 27130 74817 188216 441545 977958 2061371 4159099 8069378",
    "7 19 40 69 106 155 228 346 534 810 1173 1614 2248 3895 10048 32638 107359 331643 953804 2573177 6572252",
    "18 33 56 87 133 216 385 744 1530 3309 7409 16795 37764 83219 179107 377282 781198 1596301 3225834 6446167 12714795",
    "24 35 38 31 27 63 214 634 1660 4029 9272 20363 42715 85629 164316 302626 536632 919231 1525938 2462063 3871475",
    "1 -5 -7 3 40 147 444 1227 3149 7538 16958 36226 74314 147984 288781 556384 1063641 2022389 3825063 7186029 13379700",
    "-8 -14 -23 -37 -47 -13 171 740 2183 5496 12664 27504 57041 113704 218985 410128 753470 1372130 2503151 4611805 8611109",
    "12 29 47 71 126 282 690 1629 3564 7215 13637 24311 41246 67092 105264 160077 236892 342273 484155 672023 917102",
    "2 9 29 74 161 318 590 1045 1780 2927 4659 7196 10811 15836 22668 31775 43702 59077 78617 103134 133541",
    "11 6 6 21 57 111 162 159 25 -266 -413 926 7704 29621 88038 226774 531483 1164086 2423424 4850939 9412207",
    "10 6 7 29 101 268 592 1165 2167 4035 7866 16266 34982 75810 161429 332880 660197 1255890 2289244 3996755 6681736",
    "4 4 13 39 90 180 340 635 1200 2334 4731 9981 21542 46466 98258 201357 397852 757184 1389737 2465387 4238258",
    "10 19 39 70 125 259 613 1473 3344 7039 13783 25332 44107 73343 117253 181207 271926 397691 568567 796642 1096281",
    "-5 -10 -19 -36 -68 -115 -139 4 699 2828 8238 20564 46618 98639 197798 379464 700859 1251858 2169819 3659452 6018848",
    "18 43 95 193 369 678 1214 2149 3822 6917 12786 23998 45235 84726 156537 284262 507050 889543 1538305 2628839 4449501",
    "19 40 88 188 376 705 1255 2145 3545 5686 8866 13450 19862 28567 40041 54727 72975 94964 120604 149416 180388",
    "7 9 25 68 164 364 756 1477 2725 4771 7971 12778 19754 29582 43078 61203 85075 115981 155389 204960 266560",
    "27 50 83 126 179 242 315 398 491 594 707 830 963 1106 1259 1422 1595 1778 1971 2174 2387",
    "19 33 47 65 106 221 532 1321 3227 7657 17586 39014 83468 172087 342011 656014 1216579 2185913 3813745 6475143 10721030",
    "-1 0 -2 1 34 151 463 1203 2874 6562 14542 31360 65637 132911 259909 490722 895441 1581900 2711262 4518275 7337116",
    "2 9 22 44 80 137 224 352 534 785 1122 1564 2132 2849 3740 4832 6154 7737 9614 11820 14392",
    "4 24 67 141 253 420 701 1277 2619 5807 13118 29128 62851 132023 271835 552811 1117218 2252402 4536321 9121315 18276637",
    "7 28 74 166 344 691 1379 2751 5464 10751 20942 40563 78690 153910 304464 608308 1221597 2450652 4883947 9631069 18752762",
    "12 20 36 76 165 337 652 1244 2414 4782 9512 18624 35407 64947 114784 195712 322736 516200 803100 1218596 1807737",
    "12 38 77 142 255 448 762 1238 1907 2825 4284 7495 16338 41287 107457 270035 642342 1444672 3086167 6297676 12341241",
    "11 20 54 135 294 583 1098 2015 3642 6491 11375 19536 32811 53844 86353 135462 208109 313542 463916 675005 967044",
    "21 43 83 157 300 579 1104 2037 3610 6183 10402 17555 30271 53763 97881 180315 331371 600835 1067541 1852369 3135518",
    "-3 -2 -1 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17",
    "10 21 43 94 213 478 1043 2216 4613 9447 19057 37882 74319 144439 279676 542857 1061088 2091197 4145267 8222450 16221613",
    "13 33 55 78 106 154 274 613 1508 3623 8158 17244 34855 69082 137769 281980 596795 1298750 2867746 6335202 13851090",
    "3 12 41 114 260 508 882 1396 2049 2820 3663 4502 5226 5684 5680 4968 3247 156 -4731 -11910 -21952",
    "11 29 68 135 238 402 705 1338 2688 5438 10673 19976 35493 59941 96528 148749 220017 313083 429194 566933 720680",
    "11 26 65 142 267 451 721 1156 1961 3594 6946 13541 25674 46362 79007 126886 193211 283894 417835 654276 1154561",
    "12 15 24 39 60 87 120 159 204 255 312 375 444 519 600 687 780 879 984 1095 1212",
    "4 19 45 73 89 84 74 126 389 1139 2864 6439 13472 26940 52279 99144 184114 334683 594951 1033509 1754099",
    "-4 -4 -5 5 53 187 494 1146 2502 5309 11072 22715 45754 90402 175459 335815 637548 1209138 2306369 4445597 8670855",
    "0 -10 -14 -1 40 120 250 441 704 1050 1490 2035 2696 3484 4410 5485 6720 8126 9714 11495 13480",
    "-1 2 6 25 100 327 896 2149 4674 9470 18264 34160 62980 115946 214775 400835 750749 1401734 2591006 4714735 8413240",
    "3 0 7 38 122 316 735 1615 3428 7072 14164 27470 51513 93408 163982 279247 462305 745776 1174853 1811102 2737140",
    "10 13 22 50 119 260 513 927 1560 2479 3760 5488 7757 10670 14339 18885 24438 31137 39130 48574 59635",
    "10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50",
    "14 18 41 98 204 374 623 966 1418 1994 2709 3578 4616 5838 7259 8894 10758 12866 15233 17874 20804",
    "20 34 63 119 231 457 896 1700 3086 5348 8869 14133 21737 32403 46990 66506 92120 125174 167195 219907 285243",
    "0 -1 -6 -6 21 121 396 1079 2681 6246 13757 28743 57144 108498 197521 346158 586190 962489 1537020 2393696 3644199",
    "10 19 23 32 66 155 339 668 1202 2011 3175 4784 6938 9747 13331 17820 23354 30083 38167 47776 59090",
    "20 33 50 79 140 275 558 1105 2084 3725 6330 10283 16060 24239 35510 50685 70708 96665 129794 171495 223340",
    "12 7 7 29 100 257 547 1027 1764 2835 4327 6337 8972 12349 16595 21847 28252 35967 45159 56005 68692",
    "7 21 47 91 177 351 685 1289 2344 4182 7464 13545 25170 47749 91736 177439 345754 683628 1384994 2892852 6217144",
    "-4 -6 6 47 139 322 666 1279 2306 3914 6258 9423 13337 17650 21574 23679 21640 11930 -10546 -52881 -124665",
    "13 25 40 57 75 93 110 125 137 145 148 145 135 117 90 53 5 -55 -128 -215 -317",
    "8 25 44 71 127 268 619 1421 3096 6349 12362 23214 42806 78801 146418 275345 521540 986229 1844916 3389589 6087397",
    "0 16 54 129 267 514 949 1701 2970 5052 8368 13497 21213 32526 48727 71437 102660 144840 200922 274417 369471",
    "16 35 69 130 242 440 765 1255 1932 2785 3749 4680 5326 5294 4013 693 -5720 -16593 -33659 -59074 -95478",
    "-7 -13 -10 25 123 316 631 1088 1706 2535 3771 6087 11438 24784 57434 133058 297855 636915 1299484 2536645 4755877",
    "17 34 53 71 96 160 332 731 1539 3014 5503 9455 15434 24132 36382 53171 75653 105162 143225 191575 252164",
    "12 39 90 184 347 609 998 1526 2167 2839 3427 3940 5023 9334 24943 73355 207970 555837 1410693 3436941 8108517",
    "16 41 79 131 210 355 648 1242 2411 4635 8750 16261 30099 56499 109419 220179 456979 961910 2017346 4159724 8367565",
    "8 23 46 90 183 387 830 1762 3662 7455 14973 29950 60123 121466 246255 497581 994108 1950299 3738952 6984598 12697951",
    "11 7 -3 -24 -61 -119 -203 -318 -469 -661 -899 -1188 -1533 -1939 -2411 -2954 -3573 -4273 -5059 -5936 -6909",
    "18 25 44 82 145 242 389 613 956 1479 2266 3428 5107 7480 10763 15215 21142 28901 38904 51622 67589",
    "21 24 36 78 184 403 812 1565 3021 6026 12487 26496 56469 119083 246233 496797 975759 1864545 3469452 6303043 11234192",
    "22 34 46 58 70 82 94 106 118 130 142 154 166 178 190 202 214 226 238 250 262",
    "9 10 17 39 89 184 345 597 969 1494 2209 3155 4377 5924 7849 10209 13065 16482 20529 25279 30809",
    "-9 -1 32 103 221 398 680 1223 2443 5281 11659 25308 53416 110128 224080 454275 922411 1876460 3811966 7697822 15388707",
    "10 24 47 81 128 190 269 367 486 628 795 989 1212 1466 1753 2075 2434 2832 3271 3753 4280",
    "19 34 66 119 195 294 414 551 699 850 994 1119 1211 1254 1230 1119 899 546 34 -665 -1581",
    "6 21 37 54 75 106 156 237 364 555 831 1216 1737 2424 3310 4431 5826 7537 9609 12090 15031",
    "5 6 17 62 180 424 852 1521 2513 4044 6733 12138 23700 48274 98468 196057 376789 696954 1242145 2138702 3568396",
    "6 17 44 104 231 501 1077 2282 4720 9498 18667 36122 69446 133712 259423 509277 1013590 2044239 4165578 8533704 17471429",
    "9 10 16 48 135 307 589 1014 1701 3100 6602 15856 39345 95103 219031 479343 1001719 2013678 3924322 7470524 13989729",
    "6 19 48 97 181 346 701 1474 3109 6423 12841 24723 45790 81646 140380 233216 375160 585571 888558 1313077 1892571",
    "11 23 30 28 20 24 90 333 987 2483 5552 11352 21616 38816 66336 108645 171459 261879 388490 561404 792228",
    "18 33 65 129 250 471 866 1576 2892 5410 10279 19554 36652 66890 118060 200967 329822 522343 799373 1183775 1698310",
    "-1 15 45 89 145 217 339 627 1373 3202 7349 16227 34735 73343 155153 331385 714099 1543429 3322869 7086733 14919765",
    "0 4 23 78 199 423 805 1453 2594 4674 8491 15356 27273 47125 78849 127579 199732 303008 446271 639274 892187",
    "3 12 33 63 89 86 15 -183 -594 -1320 -2406 -3613 -3822 469 18862 75942 231493 624056 1559847 3685395 8307895",
    "7 4 9 38 122 313 681 1308 2311 3977 7187 14465 32240 75292 174917 393149 846471 1743850 3445581 6551112 12025294",
    "4 13 40 107 255 548 1086 2048 3796 7091 13524 26393 52549 106364 218288 453146 948708 1995617 4199880 8806295 18327603",
    "16 22 23 26 57 169 460 1110 2446 5044 9877 18518 33407 58191 98146 160690 255996 397714 603811 897538 1308533",
    "9 22 63 161 357 698 1222 1941 2849 4022 5949 10349 21901 51554 122404 279537 605753 1245718 2441851 4586153 8293237",
    "8 14 13 5 -3 8 74 253 630 1322 2483 4309 7043 10980 16472 23933 33844 46758 63305 84197 110233",
    "14 39 92 191 361 641 1103 1895 3323 5990 11013 20342 37208 66730 116714 198680 329156 531281 836762 1288233 1942067",
    "22 29 35 50 110 289 707 1532 2973 5260 8606 13145 18839 25346 31840 36773 37568 30231 8869 -34900 -112660",
    "8 16 38 98 241 545 1133 2185 3950 6758 11032 17300 26207 38527 55175 77219 105892 142604 188954 246742 317981",
    "19 25 38 64 105 159 220 278 319 325 274 140 -107 -501 -1080 -1886 -2965 -4367 -6146 -8360 -11071",
    "0 -3 4 31 101 274 690 1648 3761 8260 17565 36319 73240 144465 279652 533128 1004053 1872275 3460871 6343245 11523478",
    "1 14 52 140 322 668 1281 2304 3927 6394 10010 15148 22256 31864 44591 61152 82365 109158 142576 183788 234094",
    "10 32 57 75 83 110 262 802 2294 5868 13728 30160 63537 130192 261568 516844 1004594 1919892 3609939 6696845 12320943",
    "7 4 0 0 13 59 182 478 1158 2690 6124 13834 31158 69848 154956 337927 720465 1496500 3023760 5942656 11369243",
    "2 3 19 56 128 280 627 1417 3129 6629 13440 26259 50020 94145 177321 337548 653053 1285450 2568254 5187477 10548005",
    "2 18 56 130 264 501 912 1605 2734 4508 7200 11156 16804 24663 35352 49599 68250 92278 122792 161046 208448",
    "30 47 73 123 228 438 830 1529 2760 4985 9256 18049 37052 78680 168501 356299 734194 1465107 2825923 5270991 9523132",
    "11 19 30 47 68 85 93 120 289 921 2695 6916 16031 34722 72294 147884 301697 618913 1279762 2662519 5551040",
    "0 9 37 100 228 477 945 1796 3295 5854 10094 16962 28037 46364 78555 139658 263772 526337 1090049 2298658 4867676",
    "6 16 54 139 309 642 1287 2518 4846 9269 17825 34760 68859 137845 276266 549005 1073510 2055102 3841336 7003425 12455257",
    "16 40 89 184 362 685 1262 2300 4210 7813 14724 28044 53566 101806 191309 353858 642436 1143062 1991947 3399800 5685562",
    "23 50 92 145 199 231 204 89 -71 -38 828 3927 12098 30974 71640 155570 323268 648817 1264537 2405708 4500998",
    "-7 -4 7 26 53 88 131 182 241 308 383 466 557 656 763 878 1001 1132 1271 1418 1573",
    "8 11 18 24 33 69 198 579 1565 3889 9012 19808 41969 86934 177963 362492 736586 1491843 3002466 5981740 11754589",
    "12 9 19 55 130 257 449 719 1080 1545 2127 2839 3694 4705 5885 7247 8804 10569 12555 14775 17242",
    "8 15 24 44 84 161 319 670 1484 3373 7636 16863 35944 73705 145511 277353 512192 919691 1610952 2760518 4638732",
    "6 13 27 48 77 127 259 665 1841 4931 12384 29156 64814 137065 277446 540177 1015504 1849249 3270745 5631872 9460531",
    "-4 1 13 28 46 87 214 563 1380 3065 6223 11722 20758 34927 56304 87529 131900 193473 277169 388888 535630",
    "-1 1 6 14 25 39 56 76 99 125 154 186 221 259 300 344 391 441 494 550 609",
    "22 27 34 45 55 51 9 -106 -325 -629 -855 -539 1314 6535 18162 40854 81308 148619 254500 413253 641353",
    "2 15 36 71 136 273 591 1341 3027 6551 13408 26031 48619 89299 165479 316027 626840 1280935 2651012 5462255 11066850",
    "24 40 69 128 253 518 1078 2245 4606 9201 17811 33484 61583 111915 202944 369763 678468 1250918 2305665 4223192 7646609",
    "7 3 5 17 46 106 231 508 1145 2603 5850 12856 27590 58112 121091 251643 524598 1099822 2317290 4893438 10320309",
    "13 19 33 72 179 442 1027 2233 4577 8917 16621 29790 51543 86372 140575 222775 344533 521063 772057 1122628 1604379",
    "14 27 55 103 176 295 533 1073 2296 4917 10196 20254 38516 70279 123358 208692 340690 536959 816877 1198249 1691008",
    "15 34 74 145 252 400 602 894 1366 2231 3980 7714 15811 33191 69616 143784 290652 574955 1117393 2147718 4115301",
    "6 12 18 24 30 36 42 48 54 60 66 72 78 84 90 96 102 108 114 120 126",
    "17 47 97 175 302 522 912 1592 2735 4577 7427 11677 17812 26420 38202 53982 74717 101507 135605 178427 231562",
    "10 18 25 45 103 246 581 1358 3131 7070 15589 33649 71480 150194 313095 647921 1329755 2702922 5436870 10823531 21346024",
    "12 29 52 89 175 388 866 1825 3578 6555 11324 18613 29333 44602 65770 94445 132520 182201 246036 326945 428251",
    "15 23 36 59 97 155 238 351 499 687 920 1203 1541 1939 2402 2935 3543 4231 5004 5867 6825",
    "18 35 71 152 316 621 1158 2062 3522 5812 9400 15242 25434 44478 81519 154030 293562 554337 1025645 1849212 3242936",
    "-3 8 35 85 174 332 619 1164 2243 4422 8820 17622 35134 69976 139524 278521 554977 1098180 2145969 4121515 7753870",
    "17 26 50 111 254 551 1096 1996 3369 5369 8275 12720 20239 34582 64868 132997 290341 653412 1476068 3288309 7150600",
    "9 13 16 13 6 13 71 235 579 1216 2383 4707 9927 22697 54847 135039 329833 787886 1828868 4114402 8961116",
    "21 34 52 86 156 287 506 846 1363 2172 3508 5818 9890 17025 29258 49634 82545 134134 212772 329614 499240",
    "17 28 47 95 202 403 744 1317 2350 4391 8660 17726 36838 76563 157953 322407 649879 1291286 2524001 4843041 9104258",
    "2 0 4 25 88 242 584 1324 2938 6483 14181 30414 63306 127110 245713 457847 825338 1447518 2488834 4234551 7204268",
    "12 32 59 93 134 182 237 299 368 444 527 617 714 818 929 1047 1172 1304 1443 1589 1742"
)