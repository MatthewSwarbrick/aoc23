val sample1 = listOf(
    "RL",
    "",
    "AAA = (BBB, CCC)",
    "BBB = (DDD, EEE)",
    "CCC = (ZZZ, GGG)",
    "DDD = (DDD, DDD)",
    "EEE = (EEE, EEE)",
    "GGG = (GGG, GGG)",
    "ZZZ = (ZZZ, ZZZ)"
)

val sample2 = listOf(
    "LLR",
    "",
    "AAA = (BBB, BBB)",
    "BBB = (AAA, ZZZ)",
    "ZZZ = (ZZZ, ZZZ)"
)

val input = listOf(
    "LLRLRRLLRLRRLLRLRRLRRRLRLRLRRRLLRLRRRLRLRRRLRLRLLLRRLRLRLLRLRRLRRRLRRRLLRRLRLRRRLRRLRRRLRLLRRLRRRLRRRLRRLRLRRLLLRLRLLRRRLRRLLRLRLRRLLRLRRLLRLRRLRRLLRRRLRLRLRRRLLRRRLRRLRRRLRRRLRLRRRLRRLLLRRRLRLLLRRRLRLLRLLRRRLLRRLRRRLRRRLRLLRLRLRRRLLRRLRRRLRRLRLLRRRLRRLRRRLRRRLRRRLRLRRRLRRRLRLRRRR",
    "",
    "XGS = (FDM, XCS)",
    "PJD = (XJN, PCV)",
    "FLJ = (VRH, NBF)",
    "RXS = (DNN, DHH)",
    "DQD = (NTV, CRQ)",
    "HGJ = (QJF, JTK)",
    "JDL = (QHC, TKN)",
    "VMX = (DVX, KDB)",
    "SPX = (FMD, MQS)",
    "DSQ = (BNF, PDJ)",
    "XJQ = (QST, MFT)",
    "BGX = (MSH, JQQ)",
    "CMT = (FSP, SCN)",
    "BVV = (LPL, LPL)",
    "MBR = (BHB, RMB)",
    "VVP = (QTP, TJC)",
    "BFC = (SMR, SMR)",
    "DTN = (CMN, NVG)",
    "BVN = (BKM, KPN)",
    "BCR = (MHM, MPT)",
    "NDK = (NHG, RVN)",
    "FRR = (NKL, KKN)",
    "XDP = (GBQ, VGF)",
    "KCS = (CXN, GGR)",
    "HLG = (FMQ, NXV)",
    "MTP = (KFV, QCH)",
    "VFH = (GPQ, RFK)",
    "HSG = (JKV, KNK)",
    "THL = (CPG, BBF)",
    "FJP = (CVM, BVF)",
    "TGR = (LNL, JGD)",
    "JJD = (QLT, QMC)",
    "DQK = (NDK, NFS)",
    "KFN = (PJK, XSJ)",
    "QLN = (NKV, MGT)",
    "GJR = (HBJ, HLG)",
    "JXD = (NFK, KMD)",
    "CGM = (QHF, PJR)",
    "FPM = (DHB, VBS)",
    "NMK = (MVX, MFM)",
    "SJQ = (VBD, GKP)",
    "XVX = (KCS, TNV)",
    "FNC = (BCR, LQB)",
    "KLA = (XKM, DNG)",
    "CHD = (TPM, BHH)",
    "RMV = (PBC, QPM)",
    "BXH = (QDC, LKX)",
    "VQK = (HRJ, LBX)",
    "VNR = (SDB, JQL)",
    "TQS = (JPX, NLL)",
    "RPK = (KTX, XKP)",
    "AAA = (XMG, HJX)",
    "NQS = (TGB, RDK)",
    "JKK = (SFX, VDH)",
    "DKM = (RXJ, DXF)",
    "VGF = (MXT, LKT)",
    "KQN = (KTG, NCT)",
    "MXV = (HFT, QJM)",
    "CKP = (FMC, JPT)",
    "HGP = (JMV, DXV)",
    "VRC = (NVR, NHK)",
    "DPR = (VBV, FLJ)",
    "VBL = (PXB, BVN)",
    "GSG = (KSL, VSX)",
    "FNK = (VPD, NKN)",
    "LVB = (SQB, SQB)",
    "PRF = (HNP, TDG)",
    "TGV = (NVR, NHK)",
    "DXV = (QNK, PKL)",
    "KMP = (KVB, VMR)",
    "BTR = (LKF, PJD)",
    "QHC = (DFT, DTJ)",
    "RXM = (LRG, NPH)",
    "KTX = (RFR, QRT)",
    "JHR = (BRV, QRB)",
    "JDH = (BFX, DTN)",
    "JLQ = (TTV, GKH)",
    "CMQ = (HQL, PJP)",
    "DJF = (JTK, QJF)",
    "KVB = (MXL, PTK)",
    "DMD = (HXP, ZZZ)",
    "XJV = (CRV, JLM)",
    "JXR = (JMQ, LQM)",
    "DFT = (DRN, JQM)",
    "JSC = (XFX, XFX)",
    "CKB = (VVK, XBK)",
    "RFJ = (CKP, QMH)",
    "HRP = (LQT, CJV)",
    "HXJ = (CKB, FCT)",
    "DMX = (CRV, JLM)",
    "XBK = (LVB, FXN)",
    "JVP = (SKF, LCK)",
    "JLV = (VPT, DMK)",
    "SXK = (TNR, MTF)",
    "DTJ = (JQM, DRN)",
    "KLN = (FDX, NPN)",
    "SKG = (BTR, HXG)",
    "RFR = (XCT, FHN)",
    "FKB = (JJL, CGM)",
    "HNP = (DKR, JLQ)",
    "HKC = (FDM, XCS)",
    "QQN = (MTP, DCG)",
    "QRX = (RPJ, PQM)",
    "SMD = (BBD, DSQ)",
    "SFJ = (JMR, JMR)",
    "CJZ = (QMH, CKP)",
    "PGB = (SDJ, LQF)",
    "CMS = (XSG, TFG)",
    "JMV = (PKL, QNK)",
    "GHH = (RHT, RXS)",
    "NLN = (XJX, MVC)",
    "RCG = (DCG, MTP)",
    "XHF = (SSF, CBS)",
    "PNC = (GPB, MJJ)",
    "RXC = (XHF, LDN)",
    "XVM = (NKR, KQG)",
    "MTF = (FKN, FKV)",
    "FGM = (JPJ, DFG)",
    "MTG = (RRX, FFL)",
    "HCC = (RFS, PBH)",
    "TJL = (RPJ, PQM)",
    "RDK = (RLT, MMJ)",
    "CSD = (MDQ, HSG)",
    "KVP = (VRC, TGV)",
    "QJM = (LSF, DQK)",
    "TTV = (RCC, LXJ)",
    "TJC = (RDG, LFV)",
    "BFS = (FFL, RRX)",
    "BRV = (NRJ, HCN)",
    "HXP = (XMG, HJX)",
    "NJK = (MJT, GBX)",
    "DGV = (NDH, DPB)",
    "RGD = (KBH, XDP)",
    "CRV = (QBD, QLJ)",
    "RPS = (LPH, PRR)",
    "PLF = (BHH, TPM)",
    "SJF = (LFB, NMD)",
    "HLQ = (XJX, MVC)",
    "SJR = (XKM, DNG)",
    "TQP = (BTG, QJG)",
    "MTJ = (JPJ, DFG)",
    "SQB = (RFJ, RFJ)",
    "KPN = (VTC, LDH)",
    "BDZ = (CQP, HRP)",
    "QFC = (XJQ, PMR)",
    "XMV = (HTS, RXT)",
    "MQS = (FXV, VCL)",
    "TLQ = (XMV, TSC)",
    "TCQ = (CXH, RCV)",
    "KNK = (CBD, VQK)",
    "GHD = (DBJ, VPK)",
    "TKP = (TXK, MPJ)",
    "CCC = (NKL, KKN)",
    "QFN = (TJD, JDJ)",
    "DVJ = (GQM, QKJ)",
    "TNC = (PVV, PMJ)",
    "HJX = (DQD, JDR)",
    "NFF = (JMR, GTZ)",
    "JSB = (SLS, HSC)",
    "NVR = (CTV, PNS)",
    "FNV = (XLK, FNC)",
    "JVR = (TGB, RDK)",
    "TXM = (SNN, DMZ)",
    "CNF = (KLN, BDB)",
    "QRG = (PDS, MHP)",
    "QVV = (JJD, RLL)",
    "XML = (VMR, KVB)",
    "TLB = (NTD, VKD)",
    "SDJ = (CNQ, FNV)",
    "TKN = (DTJ, DFT)",
    "HFK = (LPF, XPH)",
    "LJP = (SFJ, SFJ)",
    "SMX = (RQV, DDH)",
    "JBL = (XML, KMP)",
    "NDA = (PBF, FHP)",
    "LRP = (XKP, KTX)",
    "JCK = (BGC, CNF)",
    "XCF = (SPJ, CVR)",
    "VNV = (CMQ, JPQ)",
    "BPJ = (XVP, DXQ)",
    "MVC = (QFC, DLV)",
    "QRK = (SDJ, LQF)",
    "BFX = (CMN, NVG)",
    "JMQ = (MFC, RXD)",
    "JPQ = (PJP, HQL)",
    "FCN = (NPH, LRG)",
    "RXQ = (FMG, GJF)",
    "DVX = (GSS, CFM)",
    "CSH = (VQF, PTV)",
    "STM = (CFH, BMQ)",
    "NVF = (CSH, VHC)",
    "CKG = (VSX, KSL)",
    "BLG = (QHJ, DLB)",
    "RCB = (VVX, XCF)",
    "MGX = (HGT, HGP)",
    "NVG = (KMC, VSM)",
    "JLM = (QBD, QLJ)",
    "NKR = (HCD, RQC)",
    "QKJ = (VXK, TRR)",
    "XSJ = (TCQ, PCL)",
    "HQP = (HSJ, DGV)",
    "NPQ = (RBR, FNB)",
    "DDH = (PTQ, KQN)",
    "KTG = (DHL, KSX)",
    "MHP = (FCX, VCB)",
    "LBA = (CKP, QMH)",
    "GBX = (DLC, JRX)",
    "TKX = (RNJ, PPC)",
    "FHK = (KCV, NBK)",
    "CJV = (RCG, QQN)",
    "PPC = (JDH, SBM)",
    "KKN = (KVP, HBC)",
    "HBT = (XDM, PGN)",
    "CNC = (FVV, TCX)",
    "MXL = (BMP, BPJ)",
    "XVP = (TRL, HVN)",
    "XLX = (JSK, KNX)",
    "FCT = (VVK, XBK)",
    "CFH = (VRX, XMK)",
    "TNV = (CXN, GGR)",
    "JHK = (VQR, LDL)",
    "JPJ = (JBL, NBC)",
    "TNR = (FKV, FKN)",
    "RXJ = (SKG, BFK)",
    "QDV = (RHT, RXS)",
    "QQQ = (XHH, JVP)",
    "HGS = (MFV, DKC)",
    "NBK = (LNV, QLN)",
    "LDL = (CRJ, PRF)",
    "JRL = (KJS, PVK)",
    "FXR = (HCS, CMT)",
    "NVX = (GJR, GTQ)",
    "CFM = (SMT, SXK)",
    "TFG = (SPN, TLF)",
    "PPF = (KJN, NXJ)",
    "VPV = (HQP, KRB)",
    "MGT = (TJL, QRX)",
    "LGB = (KBH, XDP)",
    "BNS = (CTP, CBL)",
    "KSX = (BFS, MTG)",
    "GDD = (NBP, STP)",
    "CJQ = (VHM, JNQ)",
    "GQC = (NTD, VKD)",
    "FMC = (SKX, LRF)",
    "PTQ = (KTG, NCT)",
    "KNG = (BRV, QRB)",
    "KQG = (RQC, HCD)",
    "NSG = (HXJ, LBP)",
    "QPM = (KPK, XVX)",
    "CXH = (LGS, LQR)",
    "LCF = (GBS, MHB)",
    "VBD = (MBR, NBJ)",
    "SDB = (SVM, JJM)",
    "DCR = (FVK, KGG)",
    "BDJ = (XRG, CQL)",
    "JMR = (VRM, NFN)",
    "XFR = (LQM, JMQ)",
    "MBP = (CBL, CTP)",
    "GVD = (CLB, FMF)",
    "MFH = (PPC, RNJ)",
    "PTK = (BMP, BPJ)",
    "LGJ = (PXP, HJK)",
    "GKP = (MBR, NBJ)",
    "HXG = (LKF, PJD)",
    "NBC = (XML, KMP)",
    "SJG = (LPF, XPH)",
    "BKM = (VTC, LDH)",
    "DKC = (NQS, JVR)",
    "JSJ = (TQP, RLR)",
    "PMR = (QST, MFT)",
    "BRM = (PRR, LPH)",
    "KRL = (BGX, XNX)",
    "TCX = (GQC, TLB)",
    "QLJ = (FPS, JFN)",
    "HCD = (FXR, PJJ)",
    "TBN = (DSJ, VPV)",
    "FFL = (NBB, FKB)",
    "GRN = (HCC, NJF)",
    "LQB = (MHM, MPT)",
    "SFX = (LGB, RGD)",
    "HJB = (VNR, KFT)",
    "HRJ = (GLC, CHR)",
    "MJT = (DLC, JRX)",
    "FHN = (HHG, RMV)",
    "VTJ = (BFC, JTL)",
    "CQP = (CJV, LQT)",
    "VCB = (NGR, JRL)",
    "VNN = (JKK, SCK)",
    "XNT = (RXQ, LJS)",
    "SCN = (TNC, LGP)",
    "FMF = (TKP, NNT)",
    "VSM = (HNF, RLF)",
    "CNQ = (FNC, XLK)",
    "MPT = (TLQ, SBG)",
    "DSJ = (KRB, HQP)",
    "CXV = (QRK, PGB)",
    "LBX = (GLC, CHR)",
    "VBV = (NBF, VRH)",
    "TJQ = (LCH, HTJ)",
    "CPG = (QVC, CJQ)",
    "KJN = (PLB, DGH)",
    "NCM = (VTJ, SXJ)",
    "FXV = (NCM, SDH)",
    "XRG = (DPR, MXD)",
    "LCM = (PMN, VCS)",
    "SHN = (SMK, PHG)",
    "MXD = (FLJ, VBV)",
    "FDJ = (LKV, BKX)",
    "JDR = (NTV, CRQ)",
    "XDR = (LPV, XTH)",
    "RNJ = (JDH, SBM)",
    "FHP = (MGQ, HJB)",
    "PVH = (GPQ, GPQ)",
    "MGM = (RBS, HPR)",
    "VFQ = (RBR, FNB)",
    "XRV = (LCH, HTJ)",
    "DGP = (FDJ, GTJ)",
    "HJV = (DHB, VBS)",
    "KPK = (TNV, KCS)",
    "CMX = (DBJ, VPK)",
    "BHH = (VRN, SMX)",
    "PJL = (NLS, SCL)",
    "SPJ = (RXM, FCN)",
    "NTV = (TSJ, BSR)",
    "FXN = (SQB, GLR)",
    "DTK = (VVP, TCD)",
    "DBJ = (MFH, TKX)",
    "DCJ = (BTP, GVD)",
    "NMD = (DJB, MGC)",
    "PBC = (XVX, KPK)",
    "FRS = (KMD, NFK)",
    "LNL = (SQC, DTK)",
    "NGH = (XKL, HPT)",
    "RFS = (CHD, PLF)",
    "DMK = (JJT, FHK)",
    "SNS = (SHN, BMD)",
    "RLR = (BTG, QJG)",
    "FDM = (GRN, CBK)",
    "PLB = (CCT, JTT)",
    "VTC = (CMS, XSC)",
    "XKM = (QGF, TBN)",
    "MVJ = (SLB, TXM)",
    "PKL = (CSQ, SJQ)",
    "SLB = (SNN, SNN)",
    "JKV = (VQK, CBD)",
    "BBD = (BNF, PDJ)",
    "GSS = (SXK, SMT)",
    "LRG = (SPB, TGR)",
    "FDN = (JXD, FRS)",
    "XKX = (HXC, PGT)",
    "PDJ = (FRR, CCC)",
    "HXM = (VNN, VJG)",
    "QMC = (CXV, TLH)",
    "GLG = (GGV, VBL)",
    "RXT = (LCF, GBT)",
    "TGL = (NXJ, KJN)",
    "JPT = (SKX, LRF)",
    "NLL = (SPX, DDQ)",
    "BHB = (RGP, FQL)",
    "XKN = (HBT, XXG)",
    "RLT = (JLB, BDJ)",
    "SHF = (HGP, HGT)",
    "HKV = (DLB, QHJ)",
    "SVM = (XDR, BLN)",
    "PMN = (QTL, QRG)",
    "CXN = (JLV, FMT)",
    "GQV = (PJK, XSJ)",
    "HMM = (MGX, SHF)",
    "VSC = (PDH, XVM)",
    "LCK = (NSG, JPR)",
    "JQL = (JJM, SVM)",
    "FRQ = (SVG, DCR)",
    "TDG = (JLQ, DKR)",
    "SMT = (TNR, MTF)",
    "GBT = (GBS, MHB)",
    "QMH = (JPT, FMC)",
    "DXJ = (CMQ, JPQ)",
    "JJM = (XDR, BLN)",
    "DDQ = (FMD, MQS)",
    "NDH = (VVQ, DCM)",
    "LSF = (NFS, NDK)",
    "VGM = (STS, XNT)",
    "PJR = (GXF, JDL)",
    "XFC = (XVM, PDH)",
    "LBP = (CKB, FCT)",
    "KFT = (SDB, JQL)",
    "TTT = (QLS, GCV)",
    "LPH = (SJF, BPT)",
    "JGS = (XKL, HPT)",
    "VDH = (LGB, RGD)",
    "VHC = (VQF, PTV)",
    "NKN = (GDD, XDC)",
    "RND = (VGM, PSD)",
    "QVC = (VHM, JNQ)",
    "JJL = (QHF, PJR)",
    "QRB = (NRJ, HCN)",
    "MJJ = (FQT, RXC)",
    "NNA = (HRP, CQP)",
    "PBF = (MGQ, HJB)",
    "VRT = (DSS, FDN)",
    "DCM = (CLV, JCK)",
    "QLS = (SJR, SJR)",
    "RMT = (XHH, JVP)",
    "DMR = (MLF, MVJ)",
    "QJG = (NLN, HLQ)",
    "DLV = (XJQ, PMR)",
    "LKF = (XJN, PCV)",
    "VQR = (PRF, CRJ)",
    "SXJ = (BFC, JTL)",
    "MDQ = (KNK, JKV)",
    "QVD = (BVF, CVM)",
    "TGG = (LPL, BDZ)",
    "HDJ = (HGB, HSH)",
    "HTT = (LHQ, HGS)",
    "SKX = (HXM, JMF)",
    "FCX = (NGR, JRL)",
    "HSJ = (NDH, DPB)",
    "BFK = (HXG, BTR)",
    "XSG = (SPN, TLF)",
    "NCD = (MFM, MVX)",
    "PHG = (BKS, SMD)",
    "XMK = (QVD, FJP)",
    "FXL = (PGT, HXC)",
    "KBH = (VGF, GBQ)",
    "CBG = (QDC, LKX)",
    "LDN = (SSF, CBS)",
    "SVG = (FVK, KGG)",
    "BVF = (GHH, QDV)",
    "SPB = (LNL, JGD)",
    "LQR = (QXX, LCM)",
    "KHV = (JSK, KNX)",
    "LFV = (XFJ, XKN)",
    "QHG = (JJD, RLL)",
    "HGB = (LRP, RPK)",
    "NRJ = (DXJ, VNV)",
    "LKT = (PNC, LJX)",
    "MSH = (CDN, DMS)",
    "MLF = (SLB, SLB)",
    "MMJ = (JLB, BDJ)",
    "VRM = (HSR, HTT)",
    "MHM = (TLQ, SBG)",
    "LRF = (HXM, JMF)",
    "VHM = (PVH, VFH)",
    "FQL = (XRV, TJQ)",
    "MPJ = (LFS, CFJ)",
    "LMF = (CNC, KCC)",
    "JTK = (XJR, DGP)",
    "HFT = (DQK, LSF)",
    "RQV = (PTQ, KQN)",
    "LDT = (BMQ, CFH)",
    "RGP = (TJQ, XRV)",
    "SDH = (VTJ, SXJ)",
    "LKV = (JVB, TFD)",
    "KDD = (XFX, XGV)",
    "CVM = (GHH, QDV)",
    "PLS = (DVX, KDB)",
    "VCL = (NCM, SDH)",
    "SCK = (SFX, VDH)",
    "LJX = (MJJ, GPB)",
    "JTT = (LMF, SVS)",
    "PHV = (KRL, SVD)",
    "PDS = (VCB, FCX)",
    "VPD = (XDC, GDD)",
    "VRJ = (HXP, HXP)",
    "LPV = (HKC, XGS)",
    "BDB = (FDX, NPN)",
    "DXF = (BFK, SKG)",
    "FMG = (JGS, NGH)",
    "NXV = (LJP, SBT)",
    "PQM = (QVV, QHG)",
    "SNN = (PBF, FHP)",
    "LGP = (PMJ, PVV)",
    "FKV = (CBG, BXH)",
    "VJG = (JKK, SCK)",
    "JPR = (HXJ, LBP)",
    "TPM = (SMX, VRN)",
    "KXT = (VQR, LDL)",
    "NPN = (FRQ, SRD)",
    "TRL = (DCJ, BLS)",
    "CBK = (NJF, HCC)",
    "KMD = (GQV, KFN)",
    "GQM = (TRR, VXK)",
    "QST = (RMT, QQQ)",
    "XDM = (KXT, JHK)",
    "TLH = (QRK, PGB)",
    "VRH = (BNS, MBP)",
    "VVK = (LVB, LVB)",
    "HVN = (BLS, DCJ)",
    "TLJ = (HSG, MDQ)",
    "QLQ = (STM, LDT)",
    "LKX = (DBT, XTS)",
    "VXK = (DKM, KKV)",
    "XKL = (NPQ, VFQ)",
    "LDP = (BPH, RCB)",
    "VRN = (RQV, DDH)",
    "LJS = (FMG, GJF)",
    "FMT = (DMK, VPT)",
    "BPT = (LFB, NMD)",
    "RLL = (QMC, QLT)",
    "JNQ = (PVH, VFH)",
    "HJK = (JSC, KDD)",
    "QHF = (JDL, GXF)",
    "DGH = (JTT, CCT)",
    "PVV = (RND, XCQ)",
    "XFX = (VRJ, VRJ)",
    "NRN = (GQM, QKJ)",
    "VPK = (TKX, MFH)",
    "GLC = (PPF, TGL)",
    "JJT = (KCV, NBK)",
    "FVK = (XQS, PJL)",
    "VRD = (RCB, BPH)",
    "GPQ = (BVV, BVV)",
    "XCT = (HHG, RMV)",
    "VMR = (PTK, MXL)",
    "NTD = (XJV, DMX)",
    "CBS = (GHD, CMX)",
    "SNZ = (DNG, XKM)",
    "QTP = (LFV, RDG)",
    "DMZ = (FHP, PBF)",
    "LQT = (RCG, QQN)",
    "FPS = (RBX, DMR)",
    "LGS = (LCM, QXX)",
    "ZZZ = (HJX, XMG)",
    "RCV = (LQR, LGS)",
    "PBH = (CHD, PLF)",
    "JPX = (DDQ, SPX)",
    "DNN = (MXV, DVB)",
    "QRT = (XCT, FHN)",
    "HHG = (PBC, QPM)",
    "SBM = (BFX, DTN)",
    "JVB = (VSC, XFC)",
    "QNK = (CSQ, SJQ)",
    "BPM = (KNG, JHR)",
    "HBC = (TGV, VRC)",
    "MGQ = (VNR, KFT)",
    "BTP = (CLB, FMF)",
    "SVD = (BGX, XNX)",
    "RHT = (DHH, DNN)",
    "KJS = (FRN, JSB)",
    "BLS = (GVD, BTP)",
    "TJD = (JXR, XFR)",
    "RMS = (HJV, FPM)",
    "MFV = (JVR, NQS)",
    "DXQ = (HVN, TRL)",
    "HSC = (BRM, RPS)",
    "CCP = (GGV, VBL)",
    "GTB = (QKQ, PHV)",
    "RBX = (MLF, MLF)",
    "MDN = (GBX, MJT)",
    "HXC = (KPF, DJL)",
    "HSR = (HGS, LHQ)",
    "BMD = (PHG, SMK)",
    "GTZ = (NFN, VRM)",
    "LDH = (CMS, XSC)",
    "NXJ = (PLB, DGH)",
    "FGR = (GJR, GTQ)",
    "KKV = (RXJ, DXF)",
    "XCQ = (PSD, VGM)",
    "JQQ = (DMS, CDN)",
    "XCS = (GRN, CBK)",
    "JQM = (FNK, DKQ)",
    "DNG = (QGF, TBN)",
    "GBQ = (MXT, LKT)",
    "QLT = (TLH, CXV)",
    "HTL = (NLL, JPX)",
    "DLB = (VRF, THL)",
    "GTQ = (HBJ, HLG)",
    "NBB = (CGM, JJL)",
    "GPB = (FQT, RXC)",
    "QBD = (FPS, JFN)",
    "NHG = (NRN, DVJ)",
    "TRR = (KKV, DKM)",
    "DJB = (XKX, FXL)",
    "CBD = (HRJ, LBX)",
    "CFJ = (BPM, RPN)",
    "TXK = (CFJ, LFS)",
    "TCD = (QTP, TJC)",
    "XTS = (GLG, CCP)",
    "PGN = (KXT, JHK)",
    "BMP = (XVP, DXQ)",
    "CQL = (MXD, DPR)",
    "HGT = (DXV, JMV)",
    "JDJ = (XFR, JXR)",
    "KRB = (HSJ, DGV)",
    "BSR = (VRT, GTK)",
    "RMB = (RGP, FQL)",
    "BKS = (BBD, DSQ)",
    "LQM = (RXD, MFC)",
    "RQC = (FXR, PJJ)",
    "TSC = (RXT, HTS)",
    "XPH = (HGJ, DJF)",
    "NPH = (TGR, SPB)",
    "SCL = (HDJ, PQL)",
    "XHH = (LCK, SKF)",
    "CBL = (MTJ, FGM)",
    "VQF = (QLQ, XLH)",
    "LPL = (HRP, CQP)",
    "VKD = (DMX, XJV)",
    "XJX = (DLV, QFC)",
    "KCC = (TCX, FVV)",
    "GJK = (RMS, RFL)",
    "JTL = (SMR, TTT)",
    "XMG = (JDR, DQD)",
    "PQL = (HSH, HGB)",
    "LCH = (GJK, DMM)",
    "PMJ = (RND, XCQ)",
    "FRN = (SLS, HSC)",
    "CHR = (PPF, TGL)",
    "DFG = (NBC, JBL)",
    "PJJ = (HCS, CMT)",
    "CRJ = (HNP, TDG)",
    "RLF = (JSJ, GMJ)",
    "GKH = (LXJ, RCC)",
    "RNT = (TJD, JDJ)",
    "CLV = (CNF, BGC)",
    "DRN = (FNK, DKQ)",
    "RDG = (XKN, XFJ)",
    "BNF = (CCC, FRR)",
    "HQH = (HPR, RBS)",
    "QJF = (DGP, XJR)",
    "NJF = (PBH, RFS)",
    "FKN = (CBG, BXH)",
    "FSP = (LGP, TNC)",
    "RXD = (SJG, HFK)",
    "PCL = (RCV, CXH)",
    "CLB = (NNT, TKP)",
    "XNX = (JQQ, MSH)",
    "VVQ = (JCK, CLV)",
    "DHH = (DVB, MXV)",
    "MXT = (LJX, PNC)",
    "MFC = (SJG, HFK)",
    "QKQ = (SVD, KRL)",
    "CVR = (FCN, RXM)",
    "RFK = (BVV, TGG)",
    "NBP = (HQH, MGM)",
    "QXX = (VCS, PMN)",
    "PVK = (FRN, JSB)",
    "HCN = (DXJ, VNV)",
    "XLK = (LQB, BCR)",
    "HPR = (HMM, CNT)",
    "VDF = (PHV, QKQ)",
    "KNX = (LGJ, CMC)",
    "PXB = (KPN, BKM)",
    "HNF = (GMJ, JSJ)",
    "DKR = (GKH, TTV)",
    "NGR = (KJS, PVK)",
    "QDC = (XTS, DBT)",
    "LPF = (DJF, HGJ)",
    "LXJ = (FGR, NVX)",
    "NBJ = (RMB, BHB)",
    "QGF = (DSJ, VPV)",
    "KSL = (QFN, RNT)",
    "DHL = (BFS, MTG)",
    "STP = (MGM, HQH)",
    "FMQ = (LJP, LJP)",
    "TGB = (RLT, MMJ)",
    "TLF = (NCD, NMK)",
    "NLS = (PQL, HDJ)",
    "HRG = (SHN, BMD)",
    "DMM = (RMS, RFL)",
    "VPT = (JJT, FHK)",
    "SKF = (JPR, NSG)",
    "NFN = (HTT, HSR)",
    "KGG = (PJL, XQS)",
    "DHB = (CSD, TLJ)",
    "QVA = (VRM, NFN)",
    "SSF = (GHD, CMX)",
    "LFB = (DJB, MGC)",
    "GMJ = (TQP, RLR)",
    "HTS = (GBT, LCF)",
    "FQT = (LDN, XHF)",
    "TFD = (VSC, XFC)",
    "CMC = (PXP, HJK)",
    "VBS = (CSD, TLJ)",
    "DLC = (KHV, XLX)",
    "NKV = (TJL, QRX)",
    "KFV = (GSG, CKG)",
    "GGV = (BVN, PXB)",
    "DKQ = (NKN, VPD)",
    "SLS = (RPS, BRM)",
    "PJP = (VDF, GTB)",
    "BTG = (NLN, HLQ)",
    "VCS = (QTL, QRG)",
    "CSQ = (GKP, VBD)",
    "CCT = (LMF, SVS)",
    "NNT = (TXK, MPJ)",
    "XTH = (XGS, HKC)",
    "SMK = (BKS, SMD)",
    "HCS = (SCN, FSP)",
    "HPT = (NPQ, VFQ)",
    "KPF = (NVF, CDF)",
    "PDH = (KQG, NKR)",
    "PCV = (NJK, MDN)",
    "XXG = (PGN, XDM)",
    "MGC = (FXL, XKX)",
    "QTL = (PDS, MHP)",
    "JLB = (CQL, XRG)",
    "RVN = (DVJ, NRN)",
    "CTP = (FGM, MTJ)",
    "RCC = (FGR, NVX)",
    "CDF = (VHC, CSH)",
    "NKL = (HBC, KVP)",
    "PTV = (XLH, QLQ)",
    "BBF = (QVC, CJQ)",
    "TSJ = (VRT, GTK)",
    "GCV = (SJR, SNZ)",
    "NBF = (MBP, BNS)",
    "PSD = (XNT, STS)",
    "XLH = (LDT, STM)",
    "NFK = (GQV, KFN)",
    "VVX = (CVR, SPJ)",
    "PNS = (VMX, PLS)",
    "RBR = (HRG, SNS)",
    "SBT = (SFJ, NFF)",
    "DBT = (CCP, GLG)",
    "RPN = (KNG, JHR)",
    "XFJ = (HBT, XXG)",
    "JSK = (LGJ, CMC)",
    "CNT = (SHF, MGX)",
    "HBJ = (FMQ, NXV)",
    "VRX = (FJP, QVD)",
    "RBS = (CNT, HMM)",
    "STS = (RXQ, LJS)",
    "DVB = (QJM, HFT)",
    "JRX = (XLX, KHV)",
    "RPJ = (QHG, QVV)",
    "KDB = (GSS, CFM)",
    "LHQ = (MFV, DKC)",
    "RRX = (FKB, NBB)",
    "HTJ = (GJK, DMM)",
    "CDN = (VRD, LDP)",
    "NFS = (RVN, NHG)",
    "XJR = (GTJ, FDJ)",
    "NCT = (DHL, KSX)",
    "NHK = (CTV, PNS)",
    "BGC = (KLN, BDB)",
    "XJN = (MDN, NJK)",
    "MFT = (RMT, QQQ)",
    "RFL = (HJV, FPM)",
    "XQS = (NLS, SCL)",
    "BPH = (XCF, VVX)",
    "SBG = (TSC, XMV)",
    "LNV = (MGT, NKV)",
    "QCH = (CKG, GSG)",
    "JMF = (VNN, VJG)",
    "LQF = (FNV, CNQ)",
    "MVX = (HKV, BLG)",
    "SQC = (VVP, TCD)",
    "PGT = (DJL, KPF)",
    "MFM = (BLG, HKV)",
    "FMD = (VCL, FXV)",
    "VRF = (BBF, CPG)",
    "GTJ = (LKV, BKX)",
    "XGV = (VRJ, DMD)",
    "CTV = (PLS, VMX)",
    "GLR = (RFJ, CJZ)",
    "PXP = (JSC, KDD)",
    "SRD = (SVG, DCR)",
    "GGR = (FMT, JLV)",
    "HSH = (RPK, LRP)",
    "GXF = (QHC, TKN)",
    "GBS = (TQS, HTL)",
    "MHB = (HTL, TQS)",
    "GTK = (DSS, FDN)",
    "DJL = (CDF, NVF)",
    "DPB = (VVQ, DCM)",
    "DCG = (KFV, QCH)",
    "FDX = (SRD, FRQ)",
    "XKP = (QRT, RFR)",
    "FVV = (GQC, TLB)",
    "DMS = (VRD, LDP)",
    "SVS = (KCC, CNC)",
    "PRR = (SJF, BPT)",
    "LFS = (RPN, BPM)",
    "BLN = (XTH, LPV)",
    "SPN = (NMK, NCD)",
    "CMN = (KMC, VSM)",
    "QHJ = (THL, VRF)",
    "JGD = (DTK, SQC)",
    "KCV = (QLN, LNV)",
    "CRQ = (TSJ, BSR)",
    "JFN = (RBX, DMR)",
    "GJF = (NGH, JGS)",
    "VSX = (RNT, QFN)",
    "HQL = (VDF, GTB)",
    "KMC = (HNF, RLF)",
    "XSC = (TFG, XSG)",
    "XDC = (STP, NBP)",
    "PJK = (TCQ, PCL)",
    "DSS = (JXD, FRS)",
    "SMR = (QLS, QLS)",
    "BMQ = (VRX, XMK)",
    "FNB = (SNS, HRG)",
    "BKX = (TFD, JVB)"
)